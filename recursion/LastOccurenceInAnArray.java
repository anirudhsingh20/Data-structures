package recursion;

public class LastOccurenceInAnArray {
    
    public static void main(String[] args) {
        
        int arr[ ]= {1, 2, 3, 5, 6, 8, 8, 9, 7, 55, 4, 3, 7, 4, 7, 8};
                //   0  1  2  3  4  5  6  7  8  9  10  11 12 13 14 15 16
        System.out.println(lastOccurence(arr, arr.length-1, 7));
    }

    private static int lastOccurence(int[] arr, int i, int x) {

        if(arr.length == -1) return -1;

        if(arr[i] ==x) 
            return i;
        else{
            int liisa = lastOccurence(arr, i-1, x);  // last index in sub array
            return liisa;
        }
    }
}
