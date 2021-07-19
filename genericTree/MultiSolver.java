package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class MultiSolver {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int size;
    static int max; 
    static int min;
    static int height;

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

    public static void multiSolver(Node node, int depth){

        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);

        for(Node child : node.children){
            multiSolver(child, depth + 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

        // int arr[] = {10,20,-1,30,-1};

        Stack<Node> st = new Stack<>();

        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } 
            else {
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
       
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;

        multiSolver(root,0);

        System.out.println(size);
        System.out.println(min);
        System.out.println(max);
        System.out.println(height);

        System.out.println(); 

        display(root);
    }
}
