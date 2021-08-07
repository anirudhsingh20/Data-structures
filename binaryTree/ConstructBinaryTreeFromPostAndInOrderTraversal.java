package binaryTree;

public class ConstructBinaryTreeFromPostAndInOrderTraversal {
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

    static Node buildTreeFromInAndPost(int post[],int postStartIndex, int postEndIndex, int in[],int inStartIndex, int inEndIndex){
        if(inStartIndex > inEndIndex){
            return null;
        }

        int idx = inStartIndex;
        while(in[idx] != post[postEndIndex]) idx++;

        int lseCount =  idx - inStartIndex; // left subtree element count

        Node node = new Node(post[postEndIndex],null,null);

        node.leftChild = buildTreeFromInAndPost(post, postStartIndex, postStartIndex + lseCount -1, in, inStartIndex, idx -1);
        node.rightChild = buildTreeFromInAndPost(post, postStartIndex + lseCount, postEndIndex -1 , in, idx+1, inEndIndex);

        return node;
    }

    static Node buildBinaryTree(int post[],int in[]){
        int n = post.length;

        return buildTreeFromInAndPost(post, 0, n-1, in, 0, n-1);
    }

      
    public static void main(String[] args) {

        int post[] = {7,8,3,9,10,4,1,11,5,6,2,0};
        int in[] = {7,3,8,1,9,4,10,0,11,5,2,6};

        display(buildBinaryTree(post,in));

    }
}
