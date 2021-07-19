package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class AreTreesSimilar {

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

    static int size(Node node) {
        int size = 0;
        for (Node n : node.children) {
            int cs = size(n);
            size += cs;
        }
        size += 1;
        return size;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int val) {
        if (node.data == val) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for (Node child : node.children) {
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, val);
            if (pathTillChild.size() > 0) {
                pathTillChild.add(node.data); // add current root and return;
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }

    public static boolean areSimilar(Node node1, Node node2) {

        if (node1.children.size() == node2.children.size()) {
            for (int i = 0; i < node1.children.size(); i++) {
                if (!areSimilar(node1.children.get(i), node2.children.get(i))) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

        Stack<Node> st = new Stack<>(); // for creating the tree;
        
        Node root1 = null; // root element of the tree

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr1[i];
                if (st.size() > 0) {
                    st.peek().children.add(temp);
                } else {
                    root1 = temp;
                }
                st.push(temp);
            }
        }
        int arr2[] = { 12, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 }; // true

        // int arr2[] = { 10, 20, 30, 40 };  // false

        Node root2 = null; // root element of the tree
        st = new Stack<>(); // for creating the tree;

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr2[i];
                if (st.size() > 0) {
                    st.peek().children.add(temp);
                } else {
                    root2 = temp;
                }
                st.push(temp);
            }
        }
        
        System.out.println(areSimilar(root1, root2));
    }
}
