package dynamicprogramming;

public class CountWaysToTileUpTheFloor {  // tile up 2 * n floor with 2 * 1 tiles
    
    public static void main(String[] args) {
        
        countWays(5);
    }

    private static void countWays(int n) {

        int dp[] = new int[n+1]; 

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}
