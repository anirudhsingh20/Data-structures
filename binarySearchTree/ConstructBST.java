package binarySearchTree;

public class ConstructBST {
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

    public static void main(String[] args) {

        // int arr[] = { 9,12,14,17,19,23,50,54,67,72,76}; // ex.1 (sorted array)
        int arr[] = { 12, 25, 37, 50, 62, 75, 87 }; // ex.2  (sorted array)

        Node root = constructBST(arr);

        display(root);

    }
}
