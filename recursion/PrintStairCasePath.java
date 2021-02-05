package recursion;

public class PrintStairCasePath {
    
    public static void main(String[] args) {
        printStairCasePath( 4, "");
    }

    private static void printStairCasePath(int n, String ans) {  // we pass n as no of stairs

        if(n==0) {
            System.out.print(ans + " ");
            return;
        }
        else if( n < 0) {
            return;
        }
        
        printStairCasePath(n-1, ans + 1);
        printStairCasePath(n-2, ans + 2);
        printStairCasePath(n-3, ans + 3);
    }
}
