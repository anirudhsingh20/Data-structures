package searching;

import java.util.Arrays;

public class FindPairGivenDiffrence {

    static int find(int arr[],int diff, int n){
        int i =0 , j = 1;

        Arrays.sort(arr);

        while(i<n && j<diff) {

            if(arr[j] - arr[i] == diff)
                return 1;
            if(arr[j] - arr[i] < diff) {
                j++;
            }
            else if(arr[j]- arr[i] > diff){
                i++;
            }
        }

       return -1;
   }
    
    public static void main (String args[]) {

        int arr[] = {5, 20, 3, 2, 5, 80};
        int diff = 78;

        System.out.println(find(arr,diff,arr.length));

        // O(n*n) approach

        // for(int i = 0 ;i < n ;i++) {
           
        //     for(int j = i+1 ; j< n ; j++){
        //         if(Math.abs(arr[i]-arr[j]) == diff){
        //             isPresent = 1;
        //             break;
        //         }
        //     }
        //     if(isPresent == 1 ){
        //         break;
        //     }
        // }
        //System.out.println(isPresent);
    }
}
