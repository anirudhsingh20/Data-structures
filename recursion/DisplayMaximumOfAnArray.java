package recursion;

public class DisplayMaximumOfAnArray {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,200,-1,-5,0};
        System.out.println(displayMaximumOfAnArray(arr,arr.length-1));
    }

    private static int displayMaximumOfAnArray(int[] arr, int idx) {

        if(idx == 0) return arr[idx]; // initially max element at idx 0

        int max = displayMaximumOfAnArray(arr, idx -1);
        
        if(max > arr[idx]) 
            return max;
        else 
            return arr[idx];

    }
}
