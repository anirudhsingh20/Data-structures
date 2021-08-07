    package binaryTree;

    public class ConstructBinaryTreeFromPreAndInOrderTraversal {
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

        static Node buildTreeFromInAndPre(int pre[],int preStartIndex, int preEndIndex, int in[],int inStartIndex, int inEndIndex){
            if(inStartIndex > inEndIndex){
                return null;
            }

            int idx = inStartIndex;
            while(in[idx] != pre[preStartIndex]) idx++;

            int lseCount =  idx - inStartIndex; // left subtree element count

            Node node = new Node(pre[preStartIndex],null,null);

            node.leftChild = buildTreeFromInAndPre(pre, preStartIndex + 1, preStartIndex + lseCount -1, in, inStartIndex, idx -1);
            node.rightChild = buildTreeFromInAndPre(pre, preStartIndex + lseCount + 1, preEndIndex, in, idx+1, inEndIndex);

            return node;
        }

        static Node buildBinaryTree(int pre[],int in[]){
            int n = pre.length;

            return buildTreeFromInAndPre(pre, 0, n-1, in, 0, n-1);
        }

        
        public static void main(String[] args) {

            int pre[] = {0,1,3,7,8,4,9,10,2,5,11,6};
            int in[] = {7,3,8,1,9,4,10,0,11,5,2,6};

            display(buildBinaryTree(pre,in));

        }
    }
