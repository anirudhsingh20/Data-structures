package dynamicprogramming;

public class TargetSumSubsetDp {
    
    public static void main(String[] args) {
        
        //input
        int arr[] = {4,2,1,7,3};  
        int target = 10;

        isSubsetExists(arr,target);
    }

    private static void isSubsetExists(int[] arr, int target) {

        int n = arr.length;

        boolean dp[][] = new boolean [n + 1][target + 1];

        for( int i = 0 ; i < n+1; i++){
            for( int j = 0; j < target + 1 ; j++){

                if(i == 0  &&  j == 0) {
                    dp[i][j] = true;
                }
                else if ( i == 0) {
                    dp[i][j] = false;
                }
                else if ( j == 0) {
                    dp[i][j] = true;
                }
                else {
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }
                    else {
                        int val = arr[i - 1];
                        if(j >= val) {
                            if(dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        // for (boolean[] element : dp) {
        //     for (boolean element2 : elmenent) {
        //         System.out.print(element2 + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[n][target]);
    }
}
