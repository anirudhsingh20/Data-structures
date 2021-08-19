package binarySearchTree;

import java.util.*;

public class TargetSumPairBST {
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

    static Node constructBST(int in[]) {
        int n = in.length;
        return constructTreeHelper(in, 0, n - 1);
    }

    private static Node constructTreeHelper(int[] in, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;

        Node node = new Node(in[mid], null, null);

        node.leftChild = constructTreeHelper(in, start, mid - 1);
        node.rightChild = constructTreeHelper(in, mid + 1, end);

        return node;
    }

    static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data < data) {
            return find(node.rightChild, data);
        } else if (node.data > data) {
            return find(node.leftChild, data);
        } else {
            return true;
        }
    }

    // // METHOD 1

    // // static void targetSumPair(Node root, Node node, int target) {

    // // if (node == null) {
    // // return;
    // // }

    // // targetSumPair(root, node.leftChild, target);

    // // int compliment = target - node.data;
    // // if (node.data < compliment) {
    // // if (find(root, compliment)) {
    // // System.out.println("[ " +node.data + " - " + compliment + " ]");
    // // }
    // // }

    // // targetSumPair(root, node.rightChild, target);

    // // }

    // // METHOD 2
    // // static void getInOrderArrayList(Node node, ArrayList<Integer> list) {
    // // if (node == null) {
    // // return;
    // // }

    // // getInOrderArrayList(node.leftChild, list);
    // // list.add(node.data);
    // // getInOrderArrayList(node.rightChild, list);

    // // }

    // // static void targetSumPair(Node root, int target) {
    // // ArrayList<Integer> list = new ArrayList<>();
    // // getInOrderArrayList(root, list);

    // // int l = 0;
    // // int r = list.size() - 1;

    // // while (l < r) {
    // // int leftVal = list.get(l);
    // // int rightVal = list.get(r);
    // // if (leftVal + rightVal > target) {
    // // r--;
    // // } else if (leftVal + rightVal < target) {
    // // l++;
    // // } else {
    // // System.out.println(leftVal + " - " + rightVal);
    // // l++;
    // // r--;
    // // }
    // // }
    // // }

    // // METHOD 3

    static class ITPair {
        Node node;
        int state;

        ITPair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static void targetSumPair(Node node, int target) {
        if (node == null) {
            return;
        }

        Stack<ITPair> ls = new Stack<>(); // left stack
        Stack<ITPair> rs = new Stack<>(); // right stack

        ls.push(new ITPair(node, 0));
        rs.push(new ITPair(node, 0));

        Node left = getNextFromInOrder(ls);
        Node right = getNextFromReverseInOrder(rs); // greater to smaller

        while (left.data < right.data) {
            if (left.data + right.data > target) {
                right = getNextFromReverseInOrder(rs);
            } else if (left.data + right.data < target) {
                left = getNextFromInOrder(ls);
            } else {
                System.out.println(left.data + " - " + right.data);
                left = getNextFromInOrder(ls);
                right = getNextFromReverseInOrder(rs);
            }
        }

    }

    static Node getNextFromInOrder(Stack<ITPair> st) {
        while (st.size() > 0) {
            ITPair top = st.peek();

            if (top.state == 0) {   // preorder
                if (top.node.leftChild != null){
                    st.push(new ITPair(top.node.leftChild, 0));
                }
                top.state++;
            } else if (top.state == 1) {    // inorder
                if(top.node.rightChild != null){
                    st.push(new ITPair(top.node.rightChild, 0));
                }
                top.state++;
                return top.node;
            } else {    // post order
                st.pop();
            }
        }
        return null;
    }

    static Node getNextFromReverseInOrder(Stack<ITPair> st) {
        while (st.size() > 0) {
            ITPair top = st.peek();

            if (top.state == 0) {   // preorder
                if(top.node.rightChild != null){
                    st.push(new ITPair(top.node.rightChild, 0));
                }
                top.state++;
            } else if (top.state == 1) {    // inorder
                if(top.node.leftChild != null){
                    st.push(new ITPair(top.node.leftChild, 0));
                }
                top.state++;
                return top.node;
            } else {    // post order
                st.pop();
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int arr[] = { 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 }; // (sorted array)

        Node root = constructBST(arr);

        display(root);
        System.out.println();

        // METHOD 1
        // targetSumPair(root, root, 100);
        // System.out.println(list);

        // METHOD 2
        // targetSumPair(root, 100);

        // METHOD 3
        System.out.println("Pairs: ");
        targetSumPair(root, 100);
    }
}
