package arrays;
// Cyclic rotate array by one 

/* 
    ex. i/p : 9 8 7 6 4 2 1 3
        o/p ; 3 9 8 7 6 4 2 1
*/

public class ArrayCyclicRotate {
    
    public static void rotate(int arr[]){
        for(int i=arr.length -1; i> 1; i--){
            
            //swap
            arr[i] = arr[i] + arr[i-1];
            arr[i-1] = arr[i] - arr[i-1];
            arr[i] = arr[i] - arr[i-1];
        }
        for(int a:arr)
            System.out.print(a + " ");
    }
    public static void main(String args[]) {

        int array[] = { 9, 8, 7, 6, 4, 2, 1, 3};
        rotate(array); // output 3 9 8 7 6 4 2 1
    }
}
