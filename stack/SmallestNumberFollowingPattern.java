package stack;

import java.util.Stack;

public class SmallestNumberFollowingPattern {

    static void smallestNumberFollowingPattern(String pattern) {
        int n = pattern.length();
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);

            if (c == 'd') { // increase
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;

                while (st.size() > 0) {
                    System.out.print(st.pop());
                }

            }
        }
        
        st.push(num);
        while (st.size() > 0) {
            System.out.print(st.pop());
        }
    }

    public static void main(String[] args) {
        String pattern = "ddddiiii";
        //OUTPUT: 543216789
        smallestNumberFollowingPattern(pattern);

    }
}
