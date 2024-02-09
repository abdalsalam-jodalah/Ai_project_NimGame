package VersionTwoBackend;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    public static void initiateTree(MNode head,int NumberOfLevels) {
        int start = 1;
        int sum = 0;
        for (int i = 0; i < NumberOfLevels; i++) {
            head.Values.add(start);
            sum+=start;
            start += 2;
        }
        head.ActualSum=sum;
        head.isLeaf=false;
        head.NimSum=0;
        generateChildren(head);
    }
    public static void generateTree(MNode head) {
        if (!head.isLeaf) {
            generateChildren(head);

            for (MNode child : head.Childrens) {
                generateTree(child);
            }
        }
    }
    public static void generateTree(MNode head, int depth) {
        if (!head.isLeaf && depth > 0) {
            generateChildren(head);

            for (MNode child : head.Childrens) {
                generateTree(child, depth - 1);
            }
        }
    }
    public static void generateChildren(MNode head) {
        List<Integer> valuesOfHeaps = head.Values;
        List<MNode> newChildren = new ArrayList<>();

        int numberOfHeaps = valuesOfHeaps.size();

        for (int i = 0; i < numberOfHeaps; i++) {
            int sizeOfSingleHeap = valuesOfHeaps.get(i);

            for (int j = 0; j < sizeOfSingleHeap; j++) {
                List<Integer> tempList = new ArrayList<>(valuesOfHeaps);
                tempList.set(i, j);

                int actualSum = head.ActualSum - (sizeOfSingleHeap - j);

                if (actualSum >= 0 && hasNonZeroElement(tempList)) {
                    int nimSum = bitwiseXOR(tempList);
                    boolean isLeaf = (actualSum == 1 && countOnes(tempList) == 1);

                    MNode tempMNode = new MNode(tempList, actualSum, nimSum, isLeaf);
                    newChildren.add(tempMNode);
                }
            }
        }
        head.Childrens = newChildren;
    }


    private static boolean hasNonZeroElement(List<Integer> list) {
        for (int value : list) {
            if (value > 0) {
                return true;
            }
        }
        return false;
    }
    private static int countOnes(List<Integer> list) {
        int count = 0;
        for (int value : list) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }
    public static int bitwiseXOR(List<Integer> numbers) {
        int result = 0;

        for (int num : numbers) {
            result ^= num;
        }
        return result;
    }
}