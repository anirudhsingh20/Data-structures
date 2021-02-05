package recursion;

public class DisplayReverseOfAnArray {
    
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5,6};
        displayReverseOfAnArray(arr,arr.length -1);

    }

    private static void displayReverseOfAnArray(int[] arr, int i) {
        if(i == -1) return;

        displayReverseOfAnArray(arr, i-1);
        System.out.println(arr[arr.length-1 -i]);
    }
}
