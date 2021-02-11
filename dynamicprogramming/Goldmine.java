/*

sample input

6 6 
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
*/


package dynamicprogramming;

import java.util.Scanner;

public class Goldmine {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int arr[][] = new int [r] [c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        maxProfit(arr);

        sc.close();
    }
    static void maxProfit(int arr[][]) {
        int r = arr.length;
        int c = arr[0].length;

        int dp[][] = new int[r][c];

        for( int j = c -1 ; j >= 0 ; j--) {
            for( int i = 0 ; i < r ; i++) {
                if(j == c - 1)   // last col
                    dp[i][j] = arr[i][j];
                else if (i == 0)  // ist row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                else if ( i == r-1)  // last row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                else                // other cases
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],Math.max(dp[i-1][j+1],dp[i+1][j+1]));
            }
        }

        // find max in col ist;
        int max = -1;
        for(int i = 0; i < r; i++){
            if(max < dp[i][0])
                max = dp[i][0];
        }

        System.out.println(max);  // ans ( max profit )
    }
}
