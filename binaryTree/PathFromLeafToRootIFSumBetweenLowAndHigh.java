package binaryTree;

import java.util.Stack;

public class PathFromLeafToRootIFSumBetweenLowAndHigh {

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.leftChild = left;
            this.rightChild = right;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static void display(Node node) {

        if (node != null) {

            if (node.leftChild != null) {
                System.out.print(node.leftChild.data + "->");
            } else {
                System.out.print(". ->");

            }

            System.out.print(node.data + "->");

            if (node.rightChild != null) {
                System.out.print(node.rightChild.data);

            } else {
                System.out.print(" .");

            }
            System.out.println();

            display(node.leftChild);
            display(node.rightChild);
        }

    }

    static void pathFromLeafToRoot(Node node, String path, int sum, int low, int high) {
        if (node == null) {
            return;
        }

        if (node.leftChild == null && node.rightChild == null) {
            sum += node.data;

            if (low <= sum && sum <= high) {
                System.out.println(path + node.data + " " + " -> Sum: " + sum);
            }
        }

        pathFromLeafToRoot(node.leftChild, path + node.data + " ", sum + node.data, low, high);
        pathFromLeafToRoot(node.rightChild, path + node.data + " ", sum + node.data, low, high);
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Stack<Pair> st = new Stack<>();

        Node root = new Node(arr[0], null, null);

        Pair rootPair = new Pair(root, 1);

        st.push(rootPair);

        int index = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                index++;
                if (arr[index] != null) {
                    top.node.leftChild = new Node(arr[index], null, null);
                    Pair lp = new Pair(top.node.leftChild, 1);
                    st.push(lp);
                } else {
                    top.node.leftChild = null;
                }
                top.state++;
            } else if (top.state == 2) {
                index++;
                if (arr[index] != null) {
                    top.node.rightChild = new Node(arr[index], null, null);
                    Pair rp = new Pair(top.node.rightChild, 1);
                    st.push(rp);
                } else {
                    top.node.rightChild = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

        display(root);

        System.out.println();

        // logic call
        int low = 30;
        int high = 2000;
        System.out.println("Path from root to leaf where sum of node lie between low and high (low=" + low
                + ") and (high=" + high + ") :");
        pathFromLeafToRoot(root, "", 0, low, high);
    }
}
