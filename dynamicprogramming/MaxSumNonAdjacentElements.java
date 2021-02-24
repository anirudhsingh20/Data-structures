package dynamicprogramming;

public class MaxSumNonAdjacentElements {
    
    public static void main(String[] args) {

        int arr[] = { 5, 10, 10, 100, 5, 6 };  // max sum 116
        maxSum(arr);
    }

    private static void maxSum(int[] arr) {

        int inc = arr[0];  // include
        int exc = 0;       // exclude

        for ( int i = 1 ; i< arr.length; i++) {
            int prevInc = inc; 
            inc = exc + arr[i];
            exc = prevInc > exc ? prevInc : exc;
        }

        System.out.println(inc > exc ? inc : exc);  // print max of inc exc
    }
}
