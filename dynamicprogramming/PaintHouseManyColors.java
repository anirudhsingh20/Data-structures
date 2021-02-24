package dynamicprogramming;

// sample input 4 no. of house and 3 colors -> find min cost to paint each house such that no 2 adjacent house have same paint

// 4 3
// 1 5 7
// 5 8 4
// 3 2 9
// 1 2 4


import java.util.Scanner;

public class PaintHouseManyColors {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // taking input
        int noOfHouse = sc.nextInt();
        int noOfColors = sc.nextInt();

        int cost[][] = new int[noOfHouse][noOfColors];

        for(int i = 0 ; i<noOfHouse; i++) {
            for ( int j = 0 ; j < noOfColors ; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        minCost(cost);

        sc.close();
    }

    private static void minCost(int[][] cost) {

        int dp[][] = new int[cost.length][cost[0].length];
        
        // to find least and second least
        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;

        for(int i = 0 ; i< cost[0].length; i++) {
            dp[0][i] = cost[0][i];

            if(dp[0][i] < least) {
                secondLeast = least;
                least = dp[0][i];
            }
            else if(dp[0][i] < secondLeast ) {
                secondLeast = dp[0][i];
            }
        }

        for(int i = 1 ; i < cost.length; i++){

            int newLeast = Integer.MAX_VALUE;   
            int newSecondLeast = Integer.MAX_VALUE; 

            for(int j = 0 ; j< cost[0].length; j++) {
                if(least == dp[i-1][j]){
                    dp[i][j] = cost[i][j] + secondLeast;
                }
                else {
                    dp[i][j] = cost[i][j] + least;
                }

                if(dp[i][j] < newLeast) {
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                }
                else if( dp[i][j] < newSecondLeast) {
                    newSecondLeast = dp[i][j];
                }
            }

            least = newLeast; 
            secondLeast = newSecondLeast;

        }

        System.out.println(least);


    }
}
