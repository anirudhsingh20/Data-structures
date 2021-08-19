package binarySearchTree;

// // import java.util.ArrayList;

public class LcaOfBST {
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

    static int lca(Node node, int data1, int data2) {
        if (data1 < node.data && data2 < node.data) {
            return lca(node.leftChild, data1, data2);
        } else if (data1 > node.data && data2 > node.data) {
            return lca(node.rightChild, data1, data2);
        } else {
            return node.data;
        }
    }

    // // // OTHER APPROACH LENGTHY

    // // public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    // // if (node == null) {
    // // return new ArrayList<Integer>();
    // // }
    // // ArrayList<Integer> rp = new ArrayList<>();
    // // ArrayList<Integer> lp = new ArrayList<>();

    // // if (node.data < data) {
    // // rp = nodeToRootPath(node.rightChild, data);
    // // } else if (node.data > data) {
    // // lp = nodeToRootPath(node.leftChild, data);
    // // }

    // // if (lp.size() > rp.size()) {
    // // lp.add(node.data);
    // // return lp;

    // // } else {
    // // rp.add(node.data);
    // // return rp;

    // // }
    // // }

    // // public static int lca(Node node, int data1, int data2) {
    // // ArrayList<Integer> p1 = nodeToRootPath(node, data1);
    // // ArrayList<Integer> p2 = nodeToRootPath(node, data2);

    // // int i = p1.size();
    // // int j = p2.size();

    // // while (true) {
    // // if (p1.get(i - 1) == p2.get(j - 1)) {
    // // i--;
    // // j--;
    // // } else {
    // // break;
    // // }
    // // }
    // // return p1.get(i);
    // // }

    public static void main(String[] args) {

        int arr[] = { 12, 25, 37, 50, 62, 75, 87 }; // (sorted array)

        Node root = constructBST(arr);

        display(root);
        System.out.println();

        System.out.println(lca(root, 62, 87));

        // OTHER APPROACH

        // // System.out.println(nodeToRootPath(root, 62));
        // System.out.println(lca(root, 12, 87));
    }
}
