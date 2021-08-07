package binaryTree;

import java.util.Stack;

public class TransformBackFromALeftClonedTree {

    public static class Node {
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

    public static void leftCloneTree(Node node) {
        if (node == null) {
            return;
        }

        leftCloneTree(node.leftChild);
        leftCloneTree(node.rightChild);

        Node newNode = new Node(node.data, node.leftChild, null);
        node.leftChild = newNode;

    }

    public static void transformBack(Node node) {
        if (node == null) {
            return;
        }

        // if(node.leftChild != null){
        node.leftChild = node.leftChild.leftChild;
        // }
        transformBack(node.leftChild);
        transformBack(node.rightChild);

    }

    // // method 2
    // public static Node leftCloneTree2(Node node) {
    // if (node == null) {
    // return node;
    // }

    // Node lClonetree= leftCloneTree2(node.leftChild);
    // Node rClonetree= leftCloneTree2(node.rightChild);

    // Node newNode = new Node(node.data, lClonetree, null);
    // node.leftChild = newNode;
    // node.rightChild = rClonetree;

    // return node;

    // }

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
        System.out.println("Left Cloned binary tree: \n");
        leftCloneTree(root);
        display(root);
        System.out.println();
        System.out.println("Back To Normal tree: \n");
        transformBack(root);
        display(root);
        // System.out.println();
        // display(leftCloneTree2(root));
        // System.out.println();
        // display(root);
    }
}
