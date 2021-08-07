package binarySearchTree;

public class OperationOnBST {
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

    static int size(Node node) {
        if (node == null) { // base case
            return 0;
        }
        int ls = size(node.leftChild);
        int rs = size(node.rightChild);

        return ls + rs + 1;
    }

    static int sum(Node node){
        if(node == null){
            return 0;
        }
        int ls = sum(node.leftChild);
        int rs = sum(node.rightChild);
        return ls + rs + node.data;
    }

    static int min(Node node) {
        // if (node == null) { // base case
        //     return 0;
        // }
        // if(node.leftChild == null && node.rightChild == null){
        //     return node.data;
        // }

        // return min(node.leftChild);

        if(node == null){
            return 0;
        }
        if(node.leftChild != null){
            return min(node.leftChild);
        }
        else {
            return node.data;
        }

    }

    static int max(Node node) {
        // if (node == null) { // base case
        //     return 0;
        // }

        // if(node.rightChild == null && node.leftChild == null){
        //     return node.data;
        // }

        // return max(node.rightChild);

        if(node == null){
            return 0;
        }
        if(node.rightChild != null){
            return max(node.rightChild);
        }
        else {
            return node.data;
        }
    }

    static boolean find(Node node, int data) {
        if (node == null) { // base case
            return false;
        }

        if (node.data == data) {
            return true;
        } else if (node.data > data) {
            return find(node.leftChild, data);
        } else {
            return find(node.rightChild, data);
        }
    }

    public static void main(String[] args) {

        // int arr[] = { 9,12,14,17,19,23,50,54,67,72,76}; // ex.1 (sorted array)
        int arr[] = { 12, 25, 37, 50, 62, 75, 87 }; // ex.2 (sorted array)

        Node root = constructBST(arr);

        display(root);
        System.out.println();
        System.out.println("size : " + size(root));
        System.out.println("sum : " + sum(root));
        System.out.println("min : " + min(root));
        System.out.println("max : " + max(root));
        System.out.println("find : " + find(root,25));

    }
}
