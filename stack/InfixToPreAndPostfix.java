package stack;

import java.util.Stack;

public class InfixToPreAndPostfix {

    static void printPreAndPostFix(String exp) {
        Stack<Character> operators = new Stack<>();
        Stack<String> preSt = new Stack<>();
        Stack<String> postSt = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(') {
                operators.push(c);
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                preSt.push(c + "");
                postSt.push(c + "");
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // process all high or equal precedence operator
                while (operators.size() > 0 && operators.peek() != '(' && precedence(operators.peek()) >= precedence(c)) {
                    process(operators, preSt, postSt);
                }
                operators.push(c);
            } else if (c == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    process(operators, preSt, postSt);
                }
                operators.pop();
            }
        }
        while (operators.size() > 0) {
            process(operators, preSt, postSt);
        }

        System.out.println("PREFIX: " + preSt.pop());
        System.out.println("POSTFIX: " + postSt.pop());
    }

    static int precedence(char opr) {
        if (opr == '+') {
            return 1;
        } else if (opr == '-') {
            return 1;
        } else if (opr == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    static void process(Stack<Character> operators, Stack<String> preSt, Stack<String> postSt) {
        char opr = operators.pop();

        // PRE OPERATION
        String preV2 = preSt.pop();
        String preV1 = preSt.pop();

        String preResult = opr + preV1 + preV2;
        preSt.push(preResult);

        // POST OPERATION
        String postV2 = postSt.pop();
        String postV1 = postSt.pop();

        String postResult = postV1 + postV2 + opr;
        postSt.push(postResult);
    }

    public static void main(String[] args) {
        String exp = "a*(b-c)/d+e";

        printPreAndPostFix(exp);
    }
}
