package binaryTree;
import java.util.Stack;

public class LargestBST {
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

    static class BSTPair {
       boolean  isBST;
       int min;
       int max;
       int size;
       Node node;
    }

    static BSTPair largestBST;
    static BSTPair largestBST(Node node){

        // base condition
        if(node == null){
            BSTPair temp = new BSTPair();
            temp.isBST = true;
            temp.max = Integer.MIN_VALUE;
            temp.min = Integer.MAX_VALUE;
            temp.size = 0;

            return temp;
        }

        //logic
        BSTPair lp = largestBST(node.leftChild);
        BSTPair rp = largestBST(node.rightChild);

        BSTPair curr = new BSTPair();
        curr.node = node;

        curr.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data<= rp.min);

        curr.max = Math.max(node.data, Math.max(lp.max,rp.max));
        curr.min = Math.min(node.data, Math.min(lp.min,rp.min));

        curr.size = lp.size + rp.size + 1;

        if(curr.isBST && curr.size > largestBST.size){
            largestBST = curr;
        }

        return curr;
    }

   
    public static void main(String[] args) {

        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,
        77,null,null, 70, null, null, 87, null,
        null };  // op => 25@4

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

        largestBST = new BSTPair();
        // largestBST.size = 0;
        // largestBST.node = null;
        // largestBST.min = Integer.MAX_VALUE;
        // largestBST.max = Integer.MIN_VALUE;

        largestBST(root);
        System.out.println(largestBST.node.data + "@" + largestBST.size);
    }
}
