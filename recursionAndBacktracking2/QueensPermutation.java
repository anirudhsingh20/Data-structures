package recursionAndBacktracking2;

import java.util.Scanner;

public class QueensPermutation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        int chess[][] = new int[n][n];

        queensPermutation(0, chess);

    }

    public static void queensPermutation(int qsf, int chess[][]){

        if(qsf == chess.length){
            for(int i= 0; i< chess.length; i++){
                for(int j= 0; j < chess[i].length; j++){
                    if(chess[i][j] == 0){
                        System.out.print("-\t");
                    }
                    else{
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int i= 0; i < chess.length; i++){
            for(int j= 0; j < chess[i].length; j++){
                if(chess[i][j] == 0){
                    chess[i][j] = qsf + 1;
                    queensPermutation(qsf + 1, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }
}
