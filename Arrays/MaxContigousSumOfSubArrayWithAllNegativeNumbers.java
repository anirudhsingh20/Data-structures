// Program to find the maximum sum of contigous sub array (for all negative numbers)

// This works for both positive and negative numbers 

package Arrays;

public class MaxContigousSumOfSubArrayWithAllNegativeNumbers {
    
    public static void main (String args[]) {

        int arr[] = {-1,-2,-3,-4};
        int n = arr.length;
        
        if(n == 1) {
            System.out.println("Maximum contigous sub array sum is : " +  arr[0]);
        }
        else {
            int curr_max = arr[0];
            int max_so_far = arr[0];
            
            for(int i = 1; i<n ;i++){
                
                curr_max = Math.max(arr[i], curr_max + arr[i]);
                max_so_far = Math.max(max_so_far, curr_max);
            }
            System.out.println("Maximum contigous sub array sum is : " +  max_so_far);
        }

    }
}
