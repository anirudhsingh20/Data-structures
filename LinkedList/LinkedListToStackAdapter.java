package LinkedList;

import java.util.LinkedList;

public class LinkedListToStackAdapter {

    public static class StackAdapter {
        public LinkedList<Integer> list;

        StackAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (size() == 0) {
                System.out.println("stack underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int peek() {
            if (size() == 0) {
                System.out.println("stack underflow");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) {

        StackAdapter stack = new StackAdapter();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("poped :" + stack.pop());
        System.out.println("peek :" + stack.peek());
    }
}
