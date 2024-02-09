package Backend;

import com.example.aihome.GameController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static Backend.Tree.printOneLevel;

public class Game {
    public static int playHard(Node head, int whoPlay) {
        int index=machineTurn(head,1);
        List<Integer>x=getPcValues(head, head.childrens.get(index));
        GameController.changeCurrentSelected(x.get(0));
        GameController.setNumbers(x.get(1),x.get(2));

        System.out.println("number :"+x.get(1));
        System.out.println("number 2:"+x.get(2)) ;
        System.out.println("current : "+x.get(0));
        GameController.createSticksGroup1(x.get(1),x.get(2));//pc
        return index;
    }
    public static int playMedium(Node head, int whoPlay) {
        int index=machineTurn(head,2);
        List<Integer>x=getPcValues(head, head.childrens.get(index));
        GameController.changeCurrentSelected(x.get(0));
        GameController.setNumbers(x.get(1),x.get(2));
        System.out.println("number :"+x.get(1));
        System.out.println("number 2:"+x.get(2)) ;
        System.out.println("current : "+x.get(0));
        GameController.createSticksGroup1(x.get(1),x.get(2));//pc
        return index;
    }
    public static int playEasy(Node head, int whoPlay) {
        int index=machineTurn(head,3);
        List<Integer>x=getPcValues(head, head.childrens.get(index));
        GameController.changeCurrentSelected(x.get(0));
        GameController.setNumbers(x.get(1),x.get(2));
        System.out.println("number :"+x.get(1));
        System.out.println("number 2:"+x.get(2)) ;
        System.out.println("current : "+x.get(0));
        GameController.createSticksGroup1(x.get(1),x.get(2));//pc
        return index;
    }

    public static int machineTurn (Node head,int level) {
        int index = -1;
        Random random = new Random();
        System.out.println("Pc turn");
        switch (level) {
            case 1://hard

                int positiveCount = 0;
                for (int i = 0; i < head.childrens.size(); i++) {
                    Node child = head.childrens.get(i);
                    if (child.MaxMin == 1) {
                        positiveCount++;
                    }
                }
                float percentage;
                float max = Integer.MIN_VALUE;
                if (positiveCount == 0)     // no positive -> all children's are -1
                {
                    for (int i = 0; i < head.childrens.size(); i++) {
                        percentage = tieBreaker(head.childrens.get(i), 2);
                        if (percentage > max) {
                            max = percentage;
                            index = i;
                        }
                    }
                }
                else if (positiveCount == 1)// all childes -1 except one is +1
                {
                    for (int i = 0; i < head.childrens.size(); i++) {
                        Node child = head.childrens.get(i);
                        if (child.MaxMin == 1) {
                            index = i;
                            break;
                        }
                    }
                }
                else                         // mex between 1 and -1 || all positive
                {
                    for (int i = 0; i < head.childrens.size(); i++) {
                        if (head.childrens.get(i).MaxMin == 1) {
                            percentage = tieBreaker(head.childrens.get(i), 2);
                            if (percentage > max) {
                                max = percentage;
                                index = i;
                            }
                        }
                    }
                }

                break;

            case 2://medium
                List<Integer> positiveNumbers = new ArrayList<>();
                List<Integer> negativeNumbers = new ArrayList<>();
                for (int i = 0; i < head.childrens.size(); i++) {
                    Node child = head.childrens.get(i);
                    if (child.MaxMin == 1) {
                        positiveNumbers.add(i);
                    } else {
                        negativeNumbers.add(i);
                    }
                }
                if (positiveNumbers.isEmpty()) {
                    int randomNumber = random.nextInt(negativeNumbers.size());
                    index = negativeNumbers.get(randomNumber);
                } else {
                    int randomNumber = random.nextInt(positiveNumbers.size());
                    index = positiveNumbers.get(randomNumber);
                }
                break;

            case 3://easy
                index = random.nextInt(head.childrens.size());
                break;
            default:

        }
        return index;
    }
    public static int playerTurn (Node head){
        System.out.println("Your turn");
        List <Integer> templist= getPlayerMovements(head);
        for(int i=0;i<templist.size();i++){
            System.out.println(templist.get(i));
        }
        int index=-1;
        for (int i = 0; i < head.childrens.size(); i++) {
            Node child = head.childrens.get(i);
            List<Integer> copy1 = new ArrayList<>(child.matchesGroups);
            List<Integer> copy2 = new ArrayList<>(templist);

            Collections.sort(copy1);
            Collections.sort(copy2);

            if (copy1.equals(copy2)) {
                index = i;
                break;
            }
        }

        return index;
    }
    private static float tieBreaker(Node head, int depth) {
        if (head.isLeaf ){
            return head.MaxMin;
        }

        if (depth ==1)
        {
            int countNegatives=0;
            int countPositives=0;
            for (int i = 0; i < head.childrens.size(); i++) {
                Node child = head.childrens.get(i);
                if (child.MaxMin==1) countPositives++;
                else  countNegatives++;
            }
            if (countNegatives==0)countNegatives++;

            return ((float)countPositives)/((float)countNegatives);
        }
        else {
            float sum=0;
            for (int i = 0; i < head.childrens.size(); i++)
                sum += tieBreaker(head.childrens.get(i), depth-1);

            return sum;
        }
    }
    public static List<Integer> getPlayerMovements(Node head){

        System.out.println("Enter Group value: ");
        int groupValue= GameController.currentSelectedValue;

        System.out.println("Enter first value: ");
        int firstValue= GameController.number;

        System.out.println("Enter second value: ");
        int secondValue= GameController.number2;

        List <Integer> tempList=new ArrayList<>(head.matchesGroups);
        tempList.remove((Integer) groupValue);

        tempList.add(firstValue);
        tempList.add(secondValue);

        return tempList;
    }
    public static List<Integer> getPcValues(Node head, Node child) {
        List<Integer> tempList = new ArrayList<>();

        List<Integer> headGroups = new ArrayList<>(head.matchesGroups);
        List<Integer> childGroups = new ArrayList<>(child.matchesGroups);

        for (Integer value : head.matchesGroups) {
            childGroups.remove(value);
        }

        for (Integer value : child.matchesGroups) {
            headGroups.remove(value);
        }

        if (!headGroups.isEmpty()) {
            tempList.add(headGroups.get(0));
        }

        if (!childGroups.isEmpty()) {
            tempList.add(childGroups.get(0));
        }

        if (childGroups.size() > 1) {
            tempList.add(childGroups.get(1));
        }

        return tempList;
    }

}