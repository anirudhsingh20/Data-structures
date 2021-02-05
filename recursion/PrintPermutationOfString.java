package recursion;

public class PrintPermutationOfString {
    
    public static void main(String[] args) {
        printPermutaions("abcd", "");
    }

    static void printPermutaions(String ques, String ans) {

        if(ques.length() == 0 ) {
            System.out.print(ans + " ");
        }

        for(int i = 0 ; i < ques.length() ; i++) {
            char ch = ques.charAt(i);
            String subString = ques.substring(0,i) + ques.substring(i+1, ques.length());
            printPermutaions(subString, ans + ch);
        }
    }
}
