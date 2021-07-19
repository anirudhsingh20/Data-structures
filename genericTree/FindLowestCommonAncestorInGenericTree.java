package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class FindLowestCommonAncestorInGenericTree {

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
                pathTillChild.add(node.data);  // add current root and return;
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }

    public static int lowestCommonAncestor(Node node, int val1, int val2) {
        ArrayList<Integer> p1 = nodeToRootPath(node,val1);
        ArrayList<Integer> p2 = nodeToRootPath(node,val2);

        int i = p1.size() -1; 
        int j = p2.size() -1;
        while(i>=0 && j>=0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;

        return p1.get(i);
    }
    public static void main(String[] args) {
        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

        Node root = null; // root element of the tree
        Stack<Node> st = new Stack<>(); // for creating the tree;

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
        ;
        // display(root);
        System.out.println(lowestCommonAncestor(root, 110, 100));
    }
}
