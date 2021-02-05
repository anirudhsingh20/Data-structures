package recursion;

class DisplayAnArray {
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,6};
        
        disaplayAnArray(arr,arr.length -1);
    }

    static void disaplayAnArray(int arr[], int idx) {

        if(idx == -1) return;
        disaplayAnArray(arr, idx-1);
        System.out.println(arr[idx]);
    }
}