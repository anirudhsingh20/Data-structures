package dynamicprogramming;

class CountSubsequenceOfFormABC {
    public static void main(String[] args) {
        countSubsequence("abcabc");
    }

    private static void countSubsequence(String str) {

        int a = 0 ;   // aaa
        int ab = 0;   // aab
        int abc = 0;  //aabbcc
        
        for(int i = 0 ; i < str.length(); i++) {

            if(str.charAt(i) == 'a') {
                a = 2*a + 1;
            }
            else if(str.charAt(i) == 'b') {
                ab = 2 * ab + a;
            }
            else if(str.charAt(i) == 'c') {
                abc = 2 * abc + ab;
            }

        }
        System.out.println(abc);
    }
}