package dynamicprogramming;

public class CountStairPathTabulation {
    
    public static void main(String[] args) {
        System.out.println(countStairPathTabulation(10));
    }

    static int countStairPathTabulation(int n) {

        int dp[]  = new int[n + 1];

        dp[0] = 1;

        for( int i = 1 ; i <= n ; i++)  {
            if(i == 1)
                dp[i] = dp[i - 1];
            else if (i == 2)
                dp[i] = dp[i - 1] + dp [ i - 2];
            else 
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
