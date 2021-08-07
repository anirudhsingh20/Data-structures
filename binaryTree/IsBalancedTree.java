package binaryTree;

import java.util.Stack;

public class IsBalancedTree {

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

    static class BTPair {
        int height;
        boolean isBT;
    }

    static BTPair isBT(Node node) {

        // base case
        if (node == null) {
            BTPair t = new BTPair();
            t.height = 0;
            t.isBT = true;

            return t;
        }

        // logic
        BTPair lp = isBT(node.leftChild);
        BTPair rp = isBT(node.rightChild);

        BTPair currP = new BTPair();
        currP.isBT = lp.isBT && rp.isBT && (Math.abs(lp.height - rp.height) <= 1);

        currP.height = Math.max(lp.height, rp.height) + 1; // calc height;

        return currP;

    }

    // METHOD 2 - (hint : return something and update something)

    // static boolean isBalanced = true;
    // static int isBal2(Node node){ // returns height and update isBalanced value
    //     if(node == null){
    //         return 0;
    //     }
    //     int lh = isBal2(node.leftChild);
    //     int rh = isBal2(node.rightChild);

    //     if(Math.abs(lh - rh) > 1){
    //         isBalanced = false;
    //     }

    //     return Math.max(lh, rh) + 1;
    // }

    public static void main(String[] args) {

        // // True CASE
        // Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,
        // null, 70, null, null, 87, null,
        // null };

        // False CASE
        Integer[] arr = { 50, 25, 12, 11, null, null, null, null, 37, null, 30, null, 75, null, null };

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
        System.out.println(isBT(root).isBT);

        // // METHOD 2
        // isBalanced = true;
        // isBal2(root);
        // System.out.println(isBalanced);
    }
}
