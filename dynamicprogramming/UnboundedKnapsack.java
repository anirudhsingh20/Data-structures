package dynamicprogramming;

public class UnboundedKnapsack {
    
    public static void main(String[] args) {
        
        int weights[] = {2,5,1,3,4};
        int values[] = {15,14,10,45,30};
        int bagCapacity = 7;

        unboundedKnapsack(values, weights, bagCapacity);

    }

    public static void unboundedKnapsack(int values[], int[] weights, int bagCapacity) {
        int dp[] = new int[bagCapacity + 1];
        dp[0] = 0;

        for( int c = 1; c <= bagCapacity; c++) {  // c -> capacity of each dp arrary element

            int max = 0; 

            for(int i = 0 ; i < values.length; i++) {
                if(c >= weights[i]) {
                    int remCapacity = c - weights[i];
                    int remValue = dp[remCapacity];
                    int newValue = remValue + values[i];

                    if(max < newValue)
                        max= newValue;
                }
            }
            dp[c] = max;
        }
        System.out.println(dp[bagCapacity]);

    }
}
