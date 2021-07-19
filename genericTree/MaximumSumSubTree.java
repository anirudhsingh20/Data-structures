package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumSumSubTree {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static void display(Node node) {
        String str = node.data + "-> ";
        for (Node n : node.children) {
            str += n.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node n : node.children) {
            display(n);
        }
    }

    static int ceil;
    static int floor;

    public static void findCeilAndFloor(Node node, int val) {

        if (node.data > val) {
            ceil = Math.min(ceil, node.data);
        }

        if (node.data < val) {
            floor = Math.max(floor, node.data);
        }

        for (Node child : node.children) {
            findCeilAndFloor(child, val);
        }

    }

    public static int maxSum;
    public static Node maxSumNode;

    public static int maxSumSubTree(Node node) {
        int sum = 0;

        for (Node child : node.children) {
            int csum = maxSumSubTree(child);
            sum += csum;
        }

        sum += node.data;

        if (sum > maxSum) {
            maxSum = sum;
            maxSumNode = node;
        }

        return sum;
    }

    public static void main(String[] args) {
        int arr[] =  { 10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90, -1, -1, 40, -100, -1, -1,
            -1 };

        // int arr[] = {80,-110,-1,120,-1};

        Stack<Node> st = new Stack<>();

        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(temp);
                } else {
                    root = temp;
                }
                st.push(temp);
            }
        }

        display(root);
        System.out.println();

        ceil = Integer.MAX_VALUE; // smaller among larger
        floor = Integer.MIN_VALUE; // largest among smaller

        maxSum = Integer.MIN_VALUE;
        maxSumSubTree(root);

        System.out.println(maxSumNode.data + "@" + maxSum);
    }
}
