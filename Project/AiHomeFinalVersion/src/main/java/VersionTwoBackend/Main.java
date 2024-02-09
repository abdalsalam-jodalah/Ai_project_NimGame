package VersionTwoBackend;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static VersionTwoBackend.Game.play;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MNode root = new MNode();
        Tree.initiateTree(root, 4); // Adjust the number of levels as needed
        printTree(root, 0);

      //  List<Integer> tempList= play(root, Arrays.asList(1,2,5,7),0);
//        for(int i=0;i<tempList.size();i++)
//        {
//            System.out.println("Value : "+tempList.get(i));
//        }

    }













    public static void printTree(MNode node, int depth) {
        System.out.println(getIndentation(depth) + "Values: " + node.Values + " (Is Leaf: " + node.isLeaf + ")" + " NimSum: " + node.NimSum);

        for (MNode child : node.Childrens) {
            printTree(child, depth + 1);
        }
    }

    public static String getIndentation(int depth) {
        return "  ".repeat(Math.max(0, depth));
    }
}