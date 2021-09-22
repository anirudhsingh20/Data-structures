package recursionAndBacktracking2;

import java.util.Scanner;

public class NQueensCombination {

    static boolean isQueenSafe(boolean chess[][], int r, int c){

        // check row
        for(int i = 0; i< chess.length; i++){
            if(chess[i][c])
                return false;
        }

        // check col
        for(int i = 0; i< chess.length; i++){
            if(chess[r][i])
                return false;
        }

        // check diagnol 1
        for(int i = r, j = c; i>= 0 && j >= 0; i--, j--){
            if(chess[i][j])
                return false;
        }

        // check diagnol 2
        for(int i = r, j = c; i>=0 && j < chess.length; i--, j++){
            if(chess[i][j])
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
    
        boolean chess[][] = new boolean[n][n];
        queenCombination(0, n, chess, -1);
    }

    public static void queenCombination(int qsf, int tq, boolean chess[][], int lci)
    {

        if(qsf == tq){

            for(int i = 0; i< chess.length * chess.length ; i++){
                int row = i / chess.length;
                int col = i % chess.length;

                if(chess[row][col] == true){
                    System.out.print("q\t");
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


        for(int cell = lci + 1; cell < chess.length * chess.length; cell++){
            int row = cell / chess.length;
            int col = cell % chess.length;

            if(chess[row][col] == false && isQueenSafe(chess, row, col)){
                chess[row][col] = true;
                queenCombination(qsf + 1, tq, chess, cell);
                chess[row][col] = false;
            }
        }
    }
}
