package stack;

import java.util.Stack;

public class EvaluatePostFixAndConvertToInfixAndPreFix {
    static void evalAndConvert(String exp){
        Stack<String> pre = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<Integer> eval = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                pre.push(c + "");
                in.push(c + "");
                eval.push(c - '0'); // char to int type cast;
            }
            else if(c == '+' || c ==  '-' || c == '/' || c == '*'){
                char opr = c;

                // in conversion
                String inV2 = in.pop();
                String inV1 = in.pop();
                String inResult ="(" + inV1 + opr + inV2 + ")";
                in.push(inResult);

                // pre conversion
                String preV2 = pre.pop();
                String preV1 = pre.pop();
                String preResult = opr + preV1 + preV2;
                pre.push(preResult);

                int v2 = eval.pop();
                int v1 = eval.pop();
                int res = operation(opr, v1, v2);
                eval.push(res);
            
            }
        }
        System.out.println(eval.pop());
        System.out.println(in.pop());
        System.out.println(pre.pop());
    }

    static int operation(int opr, int v1, int v2){
        if(opr == '+'){
            return v1 + v2;
        }
        else if(opr == '-'){
            return v1 - v2;
        }
        else if(opr == '*'){
            return v1* v2;
        }   
        else if(opr == '/'){
            return v1 / v2;
        }
        else return 0;
    }
    public static void main(String[] args) {
        String exp = "264*8/+3-";
        evalAndConvert(exp);
    }
}
