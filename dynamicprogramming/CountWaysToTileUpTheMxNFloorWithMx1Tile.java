package dynamicprogramming;

public class CountWaysToTileUpTheMxNFloorWithMx1Tile {
    
    public static void main(String[] args) {
        countWays(8,3);
    }

    private static void countWays(int n, int m) {

        int dp[] = new int[n+1];

        for(int i = 1 ; i<= n ; i++) {
            if(i<m){
                dp[i] = 1;
            }
            else if( i == m) {
                dp[i] = 2;
            }
            else {
                dp[i]  = dp[i-1] + dp[i-m];
            }
        }

        System.out.println(dp[n]);
    }
}
