package binaryTree;

public class ConstructBinaryTreeFromInOrder {
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

    static Node buildBinaryTree(int in[]) {
        int n = in.length;

        return buildTreeFromInOrder(in, 0, n - 1);
    }

    private static Node buildTreeFromInOrder(int[] in, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end)/2;
        
        Node node = new Node(in[mid],null,null);

        node.leftChild = buildTreeFromInOrder(in, start, mid-1);
        node.rightChild = buildTreeFromInOrder(in, mid+1, end);

        return node;
    }


    public static void main(String[] args) {

        int in[] = { 9,12,14,17,19,23,50,54,67,72,76};

        display(buildBinaryTree(in));

    }
}
