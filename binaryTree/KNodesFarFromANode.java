package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class KNodesFarFromANode {

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

    static Node foundNode;

    static boolean findNode(Node node, int val) {
        if (node == null) {
            return false;
        }
        if (node.data == val) {
            foundNode = node;
            return true;
        }
        findNode(node.leftChild, val);
        findNode(node.rightChild, val);
        return false;
    }

    static void printKNodesFarFromANode(Node node, int val, int k) {
        ArrayList<Node> nodeToRoot = nodeToRootPath(node, val);

        for (int i = 0; i < nodeToRoot.size(); i++) {
            printKLevelDown(nodeToRoot.get(i), k - i, i == 0 ? null : nodeToRoot.get(i - 1));

        }
    }

    static void printKLevelDown(Node node, int k, Node blocker) {

        if (node == null || k < 0 || node == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(node.data + " ");
        }

        printKLevelDown(node.leftChild, k - 1, blocker);
        printKLevelDown(node.rightChild, k - 1, blocker);
    }

    static ArrayList<Node> nodeToRootPath(Node node, int val) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == val) {
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        ArrayList<Node> path = new ArrayList<>();

        ArrayList<Node> lPath = nodeToRootPath(node.leftChild, val);
        ArrayList<Node> RPath = nodeToRootPath(node.rightChild, val);

        if (lPath.size() > 0) {
            lPath.add(node);
            path = lPath;

        }
        if (RPath.size() > 0) {
            RPath.add(node);
            path = RPath;
        }

        return path;
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
        int k = 3;
        int val = 25;
        System.out.println("Elements K level far (k=" + k + ") and val = " + val + "):");
        printKNodesFarFromANode(root, val, k);
    }
}
