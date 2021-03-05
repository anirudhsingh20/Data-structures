package stack;

import java.util.Stack;

public class DuplicateBrackets {
    
    public static void main(String[] args) {
        String s = "((a + b) + ((c + d)))";

        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i< s.length(); i++){

            if(s.charAt(i) == ')') {

                if(st.peek() == '(') {
                    System.out.println(true + " there is duplicate brackets");
                    return;
                }
                else {
                    while(st.peek() != '(')
                    {
                        st.pop();
                    }
                    st.pop();
                }
            }
            else {
                st.push(s.charAt(i));
            }
        }

        System.out.println(false + " there is no duplicate bracket");

    }
}
