package arrays;

// import java.util.Arrays;

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
        int m = arr2.length;
        int i=0, j=0;

        while(i<n && j<m){
            if(arr1[i]<arr2[j])
                i++;
            else {
                arr1[i] = arr1[i] + arr2[j];
                arr2[j] = arr1[i] - arr2[j];
                arr1[i] = arr1[i] - arr2[j];
                i++;

                for(int k = j; k < m-1; k++) {
                    if(arr2[k] > arr2[k+1]){
                        arr2[k] = arr2[k] + arr2[k+1];
                        arr2[k+1] = arr2[k] - arr2[k+1];
                        arr2[k] = arr2[k] - arr2[k+1];
                    }
                    else {
                        break;
                    }
                }
               // j++;
            }
        }
        for(int e: arr1)
            System.out.print(e);

            // System.out.println();

        for(int e: arr2)
            System.out.print(e);
    }
}
