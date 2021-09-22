package recursionAndBacktracking2;

import java.util.Scanner;

class QueensCombination{
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        queenCombination(0, n, 0, 0, "");

    }

    public static void queenCombination(int qsf, int tq, int r, int c, String asf){

        if(r == tq){
            if(qsf == tq){
                System.out.println(asf);
            }
            return;
        }

        String yasf = "";
        String nasf = "";

        if(c == tq - 1){
            r = r + 1;
            c = 0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        }
        else{
            c = c + 1;
            yasf = asf + "q";
            nasf = asf + "-";
        }
        queenCombination(qsf + 1, tq, r, c, yasf);
        queenCombination(qsf, tq, r, c, nasf);
    }
}