package dynamicprogramming;

class CoinChangePermutation {
    public static void main(String[] args) {
        int coins[] = {2,3,5,6};
        int target = 10;

        printPermutationsPossible(coins, target);

    }
    static void printPermutationsPossible(int coins[], int target) {

        int dp[] = new int[target + 1];

        dp[0] = 1;

        for(int i = 1; i<= target ; i++) {
            for(int coin : coins) {
                if(i >= coin) {
                    dp[i] = dp[i] + dp[i-coin];
                }
            }
        }

        // for (int i : dp) {
        //     System.out.print(i + " ");
        // }
        System.out.println(dp[target]);
    }
}