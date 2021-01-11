
/*
AGGRCOW - Aggressive cows
    #binary-search
    Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. 
    The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

    His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

    Input

    t – the number of test cases, then t test cases follows.
    * Line 1: Two space-separated integers: N and C
    * Lines 2..N+1: Line i+1 contains an integer stall location, xi
    
    Output

    For each test case output one integer: the largest minimum distance.


    Example

        Input:

            1
            5 3
            1
            2
            8
            4
            9
        Output:

            3
*/
package searching;
import java.util.Arrays;



public class AggressiveCow {


    public static boolean checkIsPositionsValid(int arr[],int gap, int c){
        int prev_position = arr[0];
        int cow_count = 1;

        for (int i=1; i< arr.length ; i++) {
            if((arr[i]-prev_position)>= gap){

                if(++cow_count == c){
                    return true;
                }
                prev_position = arr[i];
            }
        }
        return false;
    }

    public static int maxDistance(int arr[],int c) {

        int low = 0;
        int high = arr[arr.length -1] - arr[0];
        int ans = 0;
        int mid;
        while(low <= high) {
            
            mid = (low + high)/2;

            if(checkIsPositionsValid(arr,mid,c)) {
                ans = Math.max(ans,mid);
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }



    public static void main(String args[]) {

        int arr[] = {79,74,57,22};  // position of stalls in barn
        int c = 4; // no of cows;
        Arrays.sort(arr); // sort array
        int maxMinimumDistanceBetweenTheCows = maxDistance(arr,c);
        System.out.println("\n" + maxMinimumDistanceBetweenTheCows);

    }
    // public static boolean checkIsPositionValid(int arr[], int gap, int c){ 
    //     int cows_placed = 1, 
    //     last_pos = arr[0];
    //     int n = arr.length;

    //     for (int i = 1; i < n; i++)
    //     {
    //       if ((arr[i] - last_pos) >= gap)
    //       {
    //         if (++cows_placed == c)
    //           return true;
    //         last_pos = arr[i];
    //       }
    //     }
    //     return false;
    // }

    // public static int maxDistance(int arr[], int c,int n){

    //     int left = arr[0], right = arr[n-1] - left;
    //     int ans = 0;

    //     while(left<=right){
    //         int mid = left + (right-left)/2;

    //         if(checkIsPositionValid(arr, mid, c)){
                
    //             ans = mid;
    //             left = mid+1;
    //         }
    //         else{
    //             right = mid -1;
    //         }
    //     }
    //     return ans;

    // }
    // public static void main (String args[]) {

    //     int c = 3;
    //     int n = 5;
    //     int arr[] = {1, 2, 8, 4, 9};
    //     Arrays.sort(arr);
    //     System.out.println(maxDistance(arr,c,n));
    // }
    
}
