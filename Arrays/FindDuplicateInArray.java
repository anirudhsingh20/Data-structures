package arrays;
import java.util.Arrays;

public class FindDuplicateInArray {
    public static void main(String args[]) {

        // +++++ O(n*n) +++++

        // ----------------------------------------------------------------------

        // int[] arr= {1,3,4,2,2};
        // boolean isFound = false;
        // int e = 0;

        // for(int i=0;i<arr.length-1 ;i++) {
        //     for(int j = i+1 ;j < arr.length ; j++) {
        //         if(arr[i]== arr[j]) {
        //             e = arr[i];
        //             isFound = true;
        //             break;
        //         }
        //     }
        //     if(isFound)
        //         break;
        // }
        // System.out.println(e);
    
        //---------------------------------------------------------------------------

        //+++++ O(nlogn) ++++++++

        int[] arr= {1,3,4,3,2};
        int e = -1;

        Arrays.sort(arr); // O(nlogn)
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] == arr[i-1])
            {
                e= arr[i];
                break;
            }
        }
        System.out.println(e);


        // using set +++++++++ O(n)

        // public int findDuplicate(int[] nums) {
        //     Set<Integer> seen = new HashSet<Integer>();
        //     for (int num : nums) {
        //         if (seen.contains(num)) {
        //             return num;
        //         }
        //         seen.add(num);
        //     }
    
        //     return -1;
        // }
        

    }
}