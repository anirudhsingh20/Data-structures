package stack;

import java.util.Stack;

public class EvaluatePrefixAndConvertToInAndPostfix {

    static void evalAndConvert(String exp) {
        Stack<Integer> eval = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                in.push(c + "");
                post.push(c + "");
                eval.push(c - '0'); // typecasting char to int

            } else if (c == '+' || c == '-' || c == '*' || c == '/') {

                char opr = c;

                // in
                String inV1 = in.pop();
                String inV2 = in.pop();
                String inResult = "(" + inV1 + opr + inV2 + ")";
                in.push(inResult);

                // post
                String postV1 = post.pop();
                String postV2 = post.pop();
                String postResult = postV1 + postV2 + opr;
                post.push(postResult);

                // eval
                int v1 = eval.pop();
                int v2 = eval.pop();
                int result = operation(opr, v1, v2);
                eval.push(result);

            }
        }

        System.out.println(eval.pop());
        System.out.println(in.pop());
        System.out.println(post.pop());
    }

    static int operation(int opr, int v1, int v2) {
        if (opr == '+') {
            return v1 + v2;
        } else if (opr == '-') {
            return v1 - v2;
        } else if (opr == '*') {
            return v1 * v2;
        } else if (opr == '/') {
            return v1 / v2;
        } else
            return 0;
    }

    public static void main(String[] args) {
        String exp = "-+2/*6483";
        evalAndConvert(exp);
        // OUTPUT;

        // 2
        // ((2+((6*4)/8))-3)
        // 264*8/+3-
    }
}
