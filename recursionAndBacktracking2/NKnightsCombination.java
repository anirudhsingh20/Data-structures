package recursionAndBacktracking2;

import java.util.Scanner;

public class NKnightsCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
    
        boolean chess[][] = new boolean[n][n];

        knightsCombination(0, n, chess, -1);
    }

    public static void knightsCombination(int ksf, int tk, boolean chess[][], int lci)
    {

        if(ksf == tk){

            for(int i = 0; i< chess.length * chess.length ; i++){
                int row = i / chess.length;
                int col = i % chess.length;

                if(chess[row][col] == true){
                    System.out.print("k\t");
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

            if(chess[row][col] == false && isKnightSafe(chess, row, col)){
                chess[row][col] = true;
                knightsCombination(ksf + 1, tk, chess, cell);
                chess[row][col] = false;
            }
        }
    }

    private static boolean isKnightSafe(boolean[][] chess, int i, int j) {

        if(i - 1 >= 0 && j -2 >= 0 && chess[i-1][j-2] == true){
            return false;
        }

        if(i - 2 >= 0 && j -1 >= 0 && chess[i-2][j-1]  == true){
            return false;
        }

        if(i - 2 >= 0 && j + 1 < chess.length && chess[i-2][j+1] == true){
            return false;
        }

        if(i - 1 >= 0 && j + 2 < chess.length && chess[i-1][j+2]  == true){
            return false;
        }

        return true;
    }
}

