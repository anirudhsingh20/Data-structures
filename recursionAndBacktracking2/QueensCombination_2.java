package recursionAndBacktracking2;

import java.util.Scanner;

public class QueensCombination_2 {
  
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        
        if(tq == qpsf){
            for(int r = 0 ; r < chess.length ; r++){
                for(int c = 0; c < chess.length; c++){
                    if(chess[r][c] == false){
                        System.out.print("-\t");
                    }
                    else {
                        System.out.print("q\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int col = j + 1; col < chess.length; col++){
            if(chess[i][col] == false){
                chess[i][col] = true;
                queensCombinations(qpsf + 1, tq, chess, i, col);
                chess[i][col] = false;
            }
        }

        for(int row = i + 1; row < chess.length; row++){
            for(int col = 0; col < chess.length; col++){
                if(chess[row][col] == false){
                    chess[row][col] = true;
                    queensCombinations(qpsf + 1, tq, chess, row, col);
                    chess[row][col] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
