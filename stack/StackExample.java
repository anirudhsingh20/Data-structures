package stack;

import java.util.Stack;

public class StackExample {
    
    public static void main(String[] args) {
        
        Stack<Integer> st = new Stack<>();

        st.push(20);
        System.out.println(st + "   \t\t top element: " + st.peek() + " stack size: " + st.size());
        st.push(30);
        st.push(40);
        System.out.println(st + "   \t top element: " + st.peek() + " stack size: " + st.size());
        st.pop();
        System.out.println(st + "   \t top element: " + st.peek() + " stack size: " + st.size());
        st.push(30);
        System.out.println(st + "   \t top element: " + st.peek() + " stack size: " + st.size());
        st.pop();
        System.out.println(st + "   \t top element: " + st.peek() + " stack size: " + st.size());


        
    }
}
