/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.

Input Format
    A number n
        (.. n more elements)
Output Format
    A number representing the number of ways to climb the stairs from 0 to top.
 */

package dynamicprogramming;

public class CountStairPathWithVariableJumps {
    
    public static void main(String[] args) {
        
        int arr[] = { 4, 3, 2, 1};  // represent no. of jumps possible from each stair
        System.out.println(countStairPathWithVariableJumps(arr));
    }

    private static int countStairPathWithVariableJumps(int[] arr) {
       
        int n = arr.length;
        int dp[] = new int[n + 1];

        dp[n] = 1;
        for(int i = n-1; i >= 0 ; i--) {
            for(int j = 1 ; j <= arr[i] && (i + j) < dp.length; j++)
            {
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }
}
