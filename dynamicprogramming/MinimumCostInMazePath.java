/* 
sample input
 6
 6
 0 1 4 2 8 2
 4 3 6 5 0 4
 1 2 4 1 4 6
 2 0 7 3 2 2
 3 1 5 9 2 4
 2 7 0 8 5 1

output
    23
*/

package dynamicprogramming;

import java.util.Scanner;

public class MinimumCostInMazePath {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int arr[][] = new int[r][c];

        for(int i = 0 ; i< r; i++)
            for(int j = 0 ; j< c ; j++)
                arr[i][j] = sc.nextInt();
        minCost(arr);

        sc.close();
    }
    static void minCost(int arr[][]) {

        int r = arr.length;
        int c = arr[0].length;
        int dp[][] = new int[r][c];

        for(int i = r-1; i>= 0; i--){
            for(int j = c-1; j>= 0 ; j--) { 
                if(i==r-1 && j==c-1) // last element (destination)
                {
                    dp[i][j] = arr[i][j];
                }
                else if(i == r-1) // last row
                {
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }
                else if(j == c-1) // last col
                {
                    dp[i][j] = dp[i+1][j] + arr[i][j];

                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
