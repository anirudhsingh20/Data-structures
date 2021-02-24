package dynamicprogramming;

// we have n people and k teams tells ways to form teams such that no team is empty

public class PartitionIntoSubset {
    
    public static void main(String[] args) {
        
        int k = 4;
        int n = 5;
        countWays(n,k);
        
    }

    private static void countWays(int n, int k) {

        int dp[][] = new int[k+1][n+1];
        
        for(int t = 1 ; t <= k ; t++) {
            for (int m = 1; m <= n ; m++) {
                if (m<t) 
                    dp[t][m] = 0;
                else if(m == t)
                    dp[t][m] = 1;
                else {
                    dp[t][m] = dp[t-1][m-1] + t * (dp[t][m-1]);
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
