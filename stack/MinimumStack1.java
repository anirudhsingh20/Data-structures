package stack;

import java.util.Stack;

class MinimumStack1 {
    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            // write your code here
            return allData.size();
        }

        void push(int val) {
            // write your code here
            allData.add(val);

            if (minData.size() == 0 || minData.peek() >= val) {
                minData.add(val);
            }
        }

        int pop() {
            // write your code here
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            int val = allData.pop();

            if (minData.size() > 0 && minData.peek() == val) {
                minData.pop();
            }

            return val;
        }

        int top() {
            // write your code here
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return allData.peek();
        }

        int min() {
            // write your code here
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return minData.peek();
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.pop();
        ms.push(10);
        ms.push(2);
        ms.push(1);
        ms.push(3);
        ms.push(4);
        ms.pop();
        System.out.println(ms.min());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());

    }
}