package recursionAndBacktracking2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        // INPUT:
        // ()())()
        // OUTPUT:
        // (())()
        // ()()()
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        removeMinParenthesis(str, getMin(str), new HashSet<>());
    }

    public static void removeMinParenthesis(String str, int minRemovalAllowed, HashSet<String> ans) {

        if (minRemovalAllowed == 0) {
            if (getMin(str) == 0) { // means valid paranthesis
                if (!ans.contains(str)) {
                    System.out.println(str);
                    ans.add(str);
                }
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);

            removeMinParenthesis(left + right, minRemovalAllowed - 1, ans);

        }
    }

    public static int getMin(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0) {
                    st.push(ch);
                } else if (st.peek() == '(') {
                    st.pop();
                } else if (st.peek() == ')') {
                    st.push(ch);
                }
            }
        }

        return st.size();
    }
}
