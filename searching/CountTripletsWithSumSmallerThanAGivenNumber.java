/* 
    Given an array arr[] of distinct integers of size N and a sum value X, 
    the task is to find count of triplets with the sum smaller than the given sum value X.

        Example 1:

        Input: N = 6, X = 2
        arr[] = {-2, 0, 1, 3}
        Output:  2
        Explanation: Below are triplets with 
        sum less than 2 (-2, 0, 1) and (-2, 0, 3). 

        Example 2:

        Input: N = 5, X = 12
        arr[] = {5, 1, 3, 4, 7}
        Output: 4
        Explanation: Below are triplets with 
        sum less than 12 (1, 3, 4), (1, 3, 5), 
        (1, 3, 7) and (1, 4, 5).

*/


package searching;

import java.util.Arrays;
public class CountTripletsWithSumSmallerThanAGivenNumber {



    // O (n*n) approach

    public static int findTripletCounts(int arr[], int sum) {

        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;

        for(int i = 0 ; i < n-2 ; i++)
        {
            int j = i+1; 
            int k = n-1;
            while (j < k) 
            {
                if(arr[i] + arr[j] + arr[k] >= sum){
                    k--;
                }
                else {
                    ans += (k-j);
                    j++;
                }
            }
        }
        return ans;
        }


    // O (n*n*n) approach

    // ***********************************************************
    // ***********************************************************

    // public static int findTripletCounts(int arr[], int sum) {

    //     int count = 0; 
    //     int n = arr.length;

    //     // n-2 because we need to keep ith element as first in triplets
    //     for(int i=0;i<n-2;i++) {
    //         // n-1 because we need to keep jth element as second in triplets
    //         for(int j = i+1; j< n-1; j++) {

    //             for (int k = j+1; k< n; k++) {
    //                 if(arr[i] + arr[j] + arr[k] < sum)
    //                     count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    
    public static void main (String args[]) {

        int arr[] = {5, 1, 3, 4, 7};
        int sum = 12;

        System.out.println(findTripletCounts(arr,sum));
    }
}
