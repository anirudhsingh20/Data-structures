package recursionAndBacktracking2;

import java.util.Scanner;

public class NQueenPermutations {

    static boolean isQueenSafe(int chess[][], int r, int c){

        // check row
        for(int i = 0; i< chess.length; i++){
            if(chess[i][c] != 0)
                return false;
        }

        // check col
        for(int i = 0; i< chess.length; i++){
            if(chess[r][i] != 0)
                return false;
        }

        // check diagnol 1 (top elements)
        for(int i = r, j = c; i>= 0 && j >= 0; i--, j--){
            if(chess[i][j] != 0)
                return false;
        }
        
        // check diagnol 1 (bottom elements)
        for(int i = r, j = c; i< chess.length && j < chess.length; i++, j++){
            if(chess[i][j] != 0)
                return false;
        }

        // check diagnol 2 (top elements)
        for(int i = r, j = c; i>=0 && j < chess.length; i--, j++){
            if(chess[i][j] != 0)
                return false;
        }

        // check diagnol 2 (bottom elements)
        for(int i = r, j = c; i < chess.length && j >= 0; i++, j--){
            if(chess[i][j] != 0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
    
        int chess[][] = new int[n][n];
        queensPermutation(0, n, chess);
    }

    public static void queensPermutation(int qsf, int tq, int chess[][])
    {

        if(qsf == tq){

            for(int i = 0; i< chess.length * chess.length ; i++){
                int row = i / chess.length;
                int col = i % chess.length;

                if(chess[row][col] != 0){
                    System.out.print("q" + chess[row][col] + "\t");
                }
                else{
                    System.out.print("-\t");
                }

                if(col == chess.length - 1){
                    System.out.println();
                }
            }
            System.out.println();

            return;
        }


        for(int cell = 0; cell < chess.length * chess.length; cell++){
            int row = cell / chess.length;
            int col = cell % chess.length;

            if(chess[row][col] == 0 && isQueenSafe(chess, row, col)){
                chess[row][col] = qsf + 1;
                queensPermutation(qsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }
    }
}

