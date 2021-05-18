package stack;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {

        // String str = "[(a+b)+{(c+d)*(e+f)}])";
        // String str = "([(a+b)+{(c+d)*(e+f)}]";
        // String str = "(([(a+b)+{(c+d)*(e+f)}]";
        String str = "[(a+b)+{(c+d)*(e+f)}]";
        // String str = "[(a)]";

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                char last_bracket = findCorrespondingLastBracket(str.charAt(i));

                while (st.size() > 0 && st.peek() != last_bracket) {
                    st.pop();
                }

                if (st.size() > 0 && st.peek() == last_bracket) {
                    st.pop();
                } 
                else {
                    System.out.println("not balanced");
                    return;
                }
            }
            else if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                st.push(str.charAt(i));
            }
        }

        if (st.size() == 0)
            System.out.println("balanced");
        else
            System.out.println("not balanced");
    }

    private static char findCorrespondingLastBracket(char ch) {
        switch (ch) {
            case ')': return '(';
            case ']': return '[';
            default :  return  '{';
        }
    }
}
