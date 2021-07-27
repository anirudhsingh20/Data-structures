package binaryTree;

import java.util.Stack;

public class BinaryTree {

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

    static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        sum += sum(node.leftChild);
        sum += sum(node.rightChild);
        sum += node.data;

        return sum;
    }

    static int max(Node node) {
        if (node == null) {
            return 0;
        }

        int max = 0;
        int maxFromLeftChild = max(node.leftChild);
        int maxFromRightChild = max(node.rightChild);

        if (max < maxFromLeftChild) {
            max = maxFromLeftChild;
        }
        if (max < maxFromRightChild) {
            max = maxFromRightChild;
        }
        if (max < node.data) {
            max = node.data;
        }

        return max;

    }

    static int height(Node node) {
        if (node == null) {
            return -1;  // for edges -1 ; for node 0
        }
        int ht = -1;

        int lht = height(node.leftChild);
        int rht = height(node.rightChild);

        ht = Math.max(lht, rht) + 1;
        // ht++;
        return ht;
    }

    static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int size = 0;
        int lsize = size(node.leftChild);
        int rsize = size(node.rightChild);

        size = lsize + rsize + 1;

        return size;
    }

    static void traversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data + " in pre-order");
        traversal(node.leftChild);
        System.out.println(node.data + " in in-order");
        traversal(node.rightChild);
        System.out.println(node.data + " in post-order");
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
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));
        System.out.println(size(root));
        System.out.println();
        traversal(root);
    }

}
