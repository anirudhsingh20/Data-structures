package recursion;

public class PrintEncoding {
    
    public static void main(String[] args) {
        printEncodint("123","");
    }

    private static void printEncodint(String ques, String ans) {

        if(ques.length() == 0 ) {

            System.out.print(ans + " ");
        }
        else if ( ques.length() == 1) {
            char ch = ques.charAt(0);
            if(ch != '0') {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncodint("", ans + code);
                // System.out.print( ans + code + " ");
            }
            else{
                return;
            }
        }
        else{

            // 1st digit
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if(ch == '0'){
                return;
            }
            else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncodint(roq, ans + code);

                // 1st and second digit
                String ch12 = ques.substring(0,2);
                String roq12 = ques.substring(2);
    
                int ch12v = Integer.parseInt(ch12);
                if(ch12v <= 26){
                    char code12 = (char)('a' + ch12v -1);
                    printEncodint(roq12, ans + code12);
                }
            }

        }
    }
}
