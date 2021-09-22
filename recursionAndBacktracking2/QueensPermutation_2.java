package recursionAndBacktracking2;

import java.util.Scanner;

public class QueensPermutation_2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        queensPermutation(new boolean[n], 0, 0, 0, n, "");

    }

    public static void queensPermutation(boolean queens[], int r, int c, int qsf, int tq, String ans){

        if(r == tq){
            if(qsf == tq){
                System.out.println(ans);
                System.out.println();
            }
            return;
        }

        char sep = '\0';
        if(c == tq - 1){
            r = r + 1;
            c = 0;
            sep = '\n';
        }
        else {
            c = c + 1;
            sep = '\t';
        }

        for(int i = 0 ; i< tq; i++){
            if(queens[i] == false){
                queens[i] = true;
                queensPermutation(queens, r, c, qsf + 1, tq, ans + "q" + (i + 1) + sep);
                queens[i] = false;
            }
        }
        queensPermutation(queens, r, c, qsf, tq, ans + "-" + sep);
    }
}
