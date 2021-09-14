package binaryTree;

import java.util.Stack;

public class IsBinarySearchTree {

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

    static class BSTpair {
        boolean isBST;
        int min;
        int max;
    }

    static BSTpair isBST(Node node) {

        // base condition
        if (node == null) {
            BSTpair temp = new BSTpair();

            temp.max = Integer.MIN_VALUE;
            temp.min = Integer.MAX_VALUE;
            temp.isBST = true;

            return temp;
        }

        // logic

        BSTpair lBSTpair = isBST(node.leftChild);
        BSTpair rBSTpair = isBST(node.rightChild);

        BSTpair currBSTpair = new BSTpair();
        currBSTpair.isBST = lBSTpair.isBST && rBSTpair.isBST
                && (node.data >= lBSTpair.max && node.data <= rBSTpair.min);

        currBSTpair.max = Math.max(node.data, Math.max(lBSTpair.max, rBSTpair.max));
        currBSTpair.min = Math.min(node.data, Math.min(lBSTpair.min, rBSTpair.min));

        return currBSTpair;
    }

    // // not correct way
    //
    // static boolean isBinarySearchTree(Node node){
    // if(node == null){
    // return true;
    // }
    // boolean isleftBst = isBinarySearchTree(node.leftChild);
    // if(!isleftBst){
    // return false;
    // }
    // boolean isRightBst = isBinarySearchTree(node.rightChild);
    // if(!isRightBst){
    // return false;
    // }
    // if(node.leftChild != null && node.leftChild.data > node.data){
    // return false;
    // }
    // if(node.rightChild != null && node.rightChild.data < node.data){
    // return false;
    // }
    // return true;

    // }
    public static void main(String[] args) {
        // true case
        Integer[] arr = { 5,1,null,null,4,3,null,null,6,null,null};

        // Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
        //     null };


        // // false case
        // Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, 40,null,null, 75, 62, 60,null,null, 76, null, null, 87, null,
        //         null };
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
        BSTpair bp = isBST(root);
        System.out.println(bp.isBST);

    }
}
