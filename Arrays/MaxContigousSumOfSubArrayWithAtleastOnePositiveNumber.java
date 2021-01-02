// Program to find the maximum sum of contigous sub array (for atleast one positive number)

package arrays;

// Kadane's algorithm
public class MaxContigousSumOfSubArrayWithAtleastOnePositiveNumber {
    
    public static void main(String args[]) {

        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};

        int max_so_far=0, max_ending_here =0;

        int start =0, end=0, s =0;

        for (int i =0 ; i < a.length; i++) {

            max_ending_here += a[i];

            if(max_ending_here > max_so_far){
                
                max_so_far = max_ending_here;
                start = s;
                end = i;
            } 
            
            if(max_ending_here < 0){

                max_ending_here = 0;
                s = i+1;
            }
        }
        
        System.out.println("Maximum Contigous Sub Array Sum is : " + max_so_far);
        System.out.println("Maximum Contigous Sub Array is : ");
        for(int i = start; i<end; i++) {
            System.out.print(a[i] + " ");
        }
        
    }
}
