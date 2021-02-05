package recursion;

public class FirstOccurenceInAnArray {
    
    public static void main(String[] args) {
        
        int arr[]= { 1,2,3,5,6,0,4,5,56,7,5,10};
        System.out.println(firstOccurence(arr, 0, 5));
    }

    private static int firstOccurence(int[] arr, int i, int x) {
        
        if(arr.length == i) 
            return -1;

        if(arr[i] == x)
            return i;
        else 
        {
            int fiisa = firstOccurence(arr, i+1, x); // first index in small array;
            return fiisa;
        }
    }
}
