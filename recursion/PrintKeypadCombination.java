package recursion;

public class PrintKeypadCombination {
    public static void main(String[] args) {
        printKPC("678","");
    }

    public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};

    private static void printKPC(String ques, String ans) {

        if(ques.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        String codesForCh = codes[ch - 48];
        for(int i = 0 ; i< codesForCh.length(); i++) {
            char cho = codesForCh.charAt(i);
            printKPC(roq, ans + cho);
        }
    }
}
