package stack;

import java.util.Stack;

public class SoveInfixExpression {

    static int solve(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                operators.push(c);
            } else if (Character.isDigit(c)) {
                operands.push(c - '0'); // to convert char to int
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // finish operation with high priority operators first
                while (operators.size() > 0 && operators.peek() != '(' && precedence(operators.peek()) >= precedence(c)) {
                    char opr = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int result = operation(v1, v2, opr);
                    operands.push(result);

                }

                operators.push(c);
            } else if (c == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    char opr = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int result = operation(v1, v2, opr);
                    operands.push(result);

                }
                operators.pop();
            }

        }

        while (operators.size() > 0) {
            char opr = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();

            int result = operation(v1, v2, opr);
            operands.push(result);

        }

        return operands.pop();
    }

    static int operation(int v1, int v2, char opr) {
        if (opr == '+') {
            return v1 + v2;
        } else if (opr == '-') {
            return v1 - v2;
        } else if (opr == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
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

    public static void main(String[] args) {
        String expression = "1-2";
        System.out.println(solve(expression));

    }
}
