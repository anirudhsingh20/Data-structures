package genericTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class IterableAndIteratorForGenericTreePreOrder {

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static class GenericTree implements Iterable<Integer> {

        Node root; 

        GenericTree(Node root){
            this.root = root;
        }

        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GenericTreePreOrderIterator(root);
            return obj;
        }
    }

    static class GenericTreePreOrderIterator implements Iterator<Integer> {

        Integer nval = null;
        Stack<Pair> st = new Stack<>();

        GenericTreePreOrderIterator(Node node){
            st.push(new Pair(node,-1));
            next();
        }

        public Integer next() {
            Integer fv = nval;
            
            nval = null;
            while(st.size() > 0){
                Pair top = st.peek();

                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                }
                else if(top.state == top.node.children.size()){
                    st.pop();
                }
                else {
                    Pair cp = new Pair(top.node.children.get(top.state),-1);
                    st.push(cp);
                    top.state++;
                }
            }
            return fv;
        }

        @Override
        public boolean hasNext() {
            if(nval == null){
                return false;
            }
            else {
                return true;
            }
        }

    }

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

    public static void main(String[] args) {
        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

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
        GenericTree tree = new GenericTree(root);

        System.out.println("Pre order traversal using iterable and iterator: \n");
        for(Integer i : tree){
            System.out.print(i + " ");
        }

    }
}
