package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderAndPostOrderTraversalIterative {

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

    static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void preOrderAndPostOrderTraversal(Node node){

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(node,-1));

        String pre = "";
        String post = "";

        while(st.size() > 0) {
            Pair top= st.peek();

            if(top.state == -1){ //pre 
                pre += top.node.data + " ";
                top.state++;
            }
            else if(top.state == top.node.children.size()){
                post += top.node.data + " ";
                st.pop();
            }
            else { // -1 < top.state < top.node.children.size()
                Pair cp = new Pair(top.node.children.get(top.state),-1);
                st.push(cp);

                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

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

        // display(root);
        System.out.println();
        preOrderAndPostOrderTraversal(root);

    }
}
