package recursionAndBacktracking2;

import java.util.Scanner;

public class NQueenBranchAndBound {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        // write your code here
        scn.close();

        boolean[] nDiagnols = new boolean[2 * n - 1]; // normal diagnols
        boolean[] rDiagnols = new boolean[2 * n - 1]; // reverse diagnols
        boolean[] cols = new boolean[n];

        solve(board, cols, nDiagnols, rDiagnols, 0, "");

    }

    private static void solve(boolean[][] board, boolean cols[], boolean[] nDiagnols, boolean[] rDiagnols, int row, String asf) {
     
        if(row == board.length){
            
            System.out.println(asf + ".");
            return;
        }
        
        for(int col = 0 ; col < board[0].length; col++){
            if(board[row][col] == false && cols[col] == false && nDiagnols[row + col] == false && rDiagnols[row - col + board.length -1] == false){
                board[row][col] = true;
                nDiagnols[row + col] = true;
                rDiagnols[row - col + board.length -1] = true;
                cols[col] = true;

                solve(board, cols, nDiagnols, rDiagnols, row + 1, asf + row + "-" + col + ", ");
                
                board[row][col] = false;
                nDiagnols[row + col] = false;
                rDiagnols[row - col + board.length -1] = false;
                cols[col] = false;
            }
        }
    }
}
