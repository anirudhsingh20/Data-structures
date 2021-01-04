package arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void swap(int a, int b) {
        a = a+b;
        b=a-b;
        a=a-b;
    }
    
    public static void main (String args[]) {


        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        int n = arr1.length;
        int i=0, j=0;

        while(i<n) {
            if(arr1[i]> arr2[j] && i<n){
                // swap(arr1[i], arr2[j])
                arr1[i] = arr1[i] + arr2[j];
                arr2[j] = arr1[i] - arr2[j];
                arr1[i] = arr1[i] - arr2[j];
                System.out.println(arr1[i] + " " + arr2[j]);
                Arrays.sort(arr2);
                i++;
            }
        }
        for(int e: arr1)
            System.out.print(e);

        for(int e: arr2)
            System.out.print(e);
    }
}
