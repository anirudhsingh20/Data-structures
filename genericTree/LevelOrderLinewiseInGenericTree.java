package genericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLinewiseInGenericTree {

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
           int cs =  size(n);
           size += cs;
        }
        size+=1;
        return size;
    }

    public static void traverse(Node node){
        System.out.println("Node pre " + node.data);

        for(Node n: node.children){
            System.out.println("Edge pre " + node.data + "--" + n.data);
            traverse(n);
            System.out.println("Edge post " + node.data + "--" + n.data);
        }
        System.out.println("Node post " + node.data);
    }

    public static void levelOrderLinewiseTraversal(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        Queue<Node> childQueue = new ArrayDeque<>();

        while(queue.size() > 0){
            node = queue.remove();
            
            System.out.print(node.data + " ");

            for(Node n : node.children){
                childQueue.add(n);
            }

            if(queue.size() == 0){
                queue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

        Node root = null; // root element of the tree
        Stack<Node> st = new Stack<>(); // for creating the tree;

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
        levelOrderLinewiseTraversal(root);
    }
}
