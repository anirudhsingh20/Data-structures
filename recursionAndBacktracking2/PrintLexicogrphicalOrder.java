package recursionAndBacktracking2;

import java.util.Scanner;

public class PrintLexicogrphicalOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i=1; i < 10 ; i++){
            dfs(i,n);
        }

        sc.close();
    }

    static void dfs(int i, int n) {
        if (i > n) { // base condition
            return;
        }
        
        System.out.println(i);

        for (int j = 0; j < 10; j++) {
            dfs(i * 10 + j, n);
        }
    }
}
