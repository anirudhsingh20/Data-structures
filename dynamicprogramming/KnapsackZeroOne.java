package dynamicprogramming;

public class KnapsackZeroOne {
    
    public static void main(String[] args) {
        int costs[] = {15,14,10,45,30};
        int weights[] = {2,5,1,3,4};
        int bagCapacity = 7;
    
        findMaxProfit(costs,weights,bagCapacity);
    }

    private static void findMaxProfit(int[] costs, int[] weights, int bagCapacity) {
        int items = weights.length;
        int dp[][] = new int[items + 1][bagCapacity + 1];

        for(int i = 1; i< items; i++ ) {
            for( int j = 1 ; j < bagCapacity; j++) {
                if(j < weights[i]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    if(dp[i-1][j - weights[i-1]] + costs[i-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i-1][j - weights[i-1]] + costs[i-1];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[items][bagCapacity]);
    }
}
