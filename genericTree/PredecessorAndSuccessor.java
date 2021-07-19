package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class PredecessorAndSuccessor {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static void display(Node node) {
        String str = node.data + "-> ";
        for (Node n : node.children) {
            str += n.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node n : node.children) {
            display(n);
        }
    }

    static int predecessor;
    static int successor;
    static int state;

    public static void findPredecessorAndSuccessor(Node node, int val) {
        if (state == 0) {
            if (node.data == val) {
                state = 1;
            } else {
                predecessor = node.data;
            }
        } else if (state == 1) {
            successor = node.data;
            state = 2;
        }

        if(state < 2){
            for (Node child : node.children) {
                findPredecessorAndSuccessor(child, val);
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

        // int arr[] = {10,20,-1,30,-1};

        Stack<Node> st = new Stack<>();

        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(temp);
                } else {
                    root = temp;
                }
                st.push(temp);
            }
        }

        System.out.println();
        // display(root);

        predecessor = Integer.MIN_VALUE;
        successor = Integer.MIN_VALUE;

        findPredecessorAndSuccessor(root, 110);

        if (predecessor > 0)
            System.out.println("predecessor : " + predecessor);

        if (successor > 0)
            System.out.println("successor : " + successor);
    }
}
