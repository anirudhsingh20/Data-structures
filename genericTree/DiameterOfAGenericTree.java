package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfAGenericTree {

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

    static int diameter = 0;

    public static int diameterofGenericTree(Node node) {
        int deepestChildHeight = -1;
        int secondDeepestChildHeight = -1;

        for (Node child : node.children) {
            int childHeight = diameterofGenericTree(child);
            if (childHeight > deepestChildHeight) 
            {
                secondDeepestChildHeight = deepestChildHeight;
                deepestChildHeight = childHeight;
            }
            else if (childHeight > secondDeepestChildHeight) 
            {
                secondDeepestChildHeight = childHeight;
            }
        }
        int candidate = secondDeepestChildHeight + deepestChildHeight + 2;
        if (candidate > diameter) 
        {
            diameter = candidate;
        }

        return ++deepestChildHeight;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, -50, -1, -60, -1, -1, 30, -70, -1, 80, -110, -1, 120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1 };

        // int arr[] = {80,-110,-1,120,-1};

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

        display(root);
        System.out.println();
        diameterofGenericTree(root);
        System.out.println(diameter);

    }
}
