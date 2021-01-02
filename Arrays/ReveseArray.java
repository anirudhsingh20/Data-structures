// Program to reverse an Array
package arrays;
import java.util.Scanner;

class ReverseArray {
    public static int[] reverse(int[] arr, int start , int end){
        while(start < end){
            
             arr[start] = arr[start] + arr[end];
             arr[end] = arr[start] -arr[end];
             arr[start] = arr[start] - arr[end];
             end--; start++;
        }
        return arr;
    }
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array (greater than 0): ");
        int length = sc.nextInt();

        int[] array = new int[length];

        System.out.println("\nEnter the integer values in the array: ");

        for(int i=0; i<array.length; i++) {
            array[i] = sc.nextInt();
        }

        reverse(array, 0, array.length - 1);

        System.out.println("\nReversed array is : ");
        for(int e : array){
            System.out.println(e);
        }
        /* 
            OTHER METHORD FOR REVERSING OF AN ARRAY 
        */

        // int[] result = new int[array.length];
        // for(int i=0, j=array.length - 1; i<array.length; i++, j-- ) {
        //     result[j] = array[i];
        // }

        // System.out.println("\nReversed array is : ");

        // for(int e : result){
        //     System.out.println(e);
        // }
        sc.close();
    }
}