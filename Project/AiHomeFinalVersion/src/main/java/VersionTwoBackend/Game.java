package VersionTwoBackend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//whoStartFlag : 1 pc
//             : 2 player
//      level  : Easy,Medium,Hard
public class Game {

    public static MNode play(MNode head, List<Integer> tempList, String level, int whoStartFlag) {
        int index = -1;

            index = playerTurn(head, tempList);
            head = head.Childrens.get(index);
            Tree.generateChildren(head);


        index = machineTurn(head, level);
        head = head.Childrens.get(index);
        Tree.generateChildren(head);
        return head;
    }
    public static MNode playPC(MNode head, List<Integer> tempList, String level, int whoStartFlag) {
        int index = -1;
        index = machineTurn(head, level);
        head = head.Childrens.get(index);
        Tree.generateChildren(head);
        return head;
    }

    public static int playerTurn(MNode head, List<Integer> tempList) {
        int index = -1;
        System.out.println("Player turn");

        for (int i = 0; i < head.Childrens.size(); i++) {
            if (head.Childrens.get(i).Values.equals(tempList)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static int machineTurn(MNode head, String level) {
        int index = -1;

        switch (level) {
            case "Hard":
                index = evalaute(head, true);
                break;
            case "Medium":
                index = selectMoveBasedOnNimSum(head);
                break;
            case "Easy":
                index = new Random().nextInt(head.Childrens.size());
                break;
            default:
        }

        return index;
    }

    public static int selectMoveBasedOnNimSum(MNode head) {
        List<Integer> zeroSums = new ArrayList<>();
        List<Integer> nonZeroSums = new ArrayList<>();

        for (int i = 0; i < head.Childrens.size(); i++) {
            MNode child = head.Childrens.get(i);
            if (child.NimSum == 0) {
                zeroSums.add(i);
            } else {
                nonZeroSums.add(i);
            }
        }

        if (zeroSums.isEmpty()) {
            return nonZeroSums.get(new Random().nextInt(nonZeroSums.size()));
        } else {
            return zeroSums.get(new Random().nextInt(zeroSums.size()));
        }
    }
    public static List<Integer> findChanges(List<Integer> list1, List<Integer> list2) {
        List<Integer> changes = new ArrayList<>();
        int minLength = Math.min(list1.size(), list2.size());

        for (int i = 0; i < minLength; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                changes.add(i);
                changes.add(list1.get(i) - list2.get(i));
            }
        }
        return changes;
    }


    public static int evalaute(MNode head, boolean isMaximizingPlayer) {
        int index = -1;


        Random random = new Random();
        List<Integer> ZeroSums = new ArrayList<>();
        List<Integer> NonZeroSum = new ArrayList<>();
        for (int i = 0; i < head.Childrens.size(); i++) {
            MNode child = head.Childrens.get(i);
            if (child.NimSum == 0) {
                ZeroSums.add(i);
            } else {
                NonZeroSum.add(i);
            }
        }
        if (ZeroSums.isEmpty()) {
            int randomNumber = random.nextInt(NonZeroSum.size());
            index = NonZeroSum.get(randomNumber);
        } else {
            int randomNumber = random.nextInt(ZeroSums.size());
            index = ZeroSums.get(randomNumber);
        }

        if (head.Childrens.get(index).ActualSum<=10){
//            index=minimax(head,true);
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < head.Childrens.size(); i++) {
                MNode child = head.Childrens.get(i);
                if(child.ActualSum<min){
                    index=i;
                    min=child.ActualSum;
                }
            }
        }
        return index;
    }
    public static int minimax(MNode node, boolean isMaximizingPlayer) {
        int nimSum = Tree.bitwiseXOR(node.Values);

        if (node.Childrens == null || nimSum == 0) {
            return -1;
        }

        int bestIndex = -1;
        int bestValue = isMaximizingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < node.Childrens.size(); i++) {
            MNode child = node.Childrens.get(i);
            int result = minimax(child, !isMaximizingPlayer);

            int currentValue = isMaximizingPlayer ? result : -result;

            if ((isMaximizingPlayer && currentValue > bestValue) ||
                    (!isMaximizingPlayer && currentValue < bestValue)) {
                bestValue = currentValue;
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}
