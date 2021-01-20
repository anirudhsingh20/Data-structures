package sorting;

// logic :
// select minimum element from array and swap with min_index 
// which is 0 in the beginning and after swap increment min_idx
public class SelectionSort {
    public static void sort(int arr[]) {
        int n = arr.length;
        for(int i = 0 ; i < n; i++) {
            int min_index = i;
            for(int j=i+1; j<n ; j++) {
                if(arr[min_index] > arr[j] )
                    min_index = j;
            }
            // swap minimum element with min_index element and increment min_index value
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,3,5,7,8,12,9,100,-1,56,9};
        sort(arr);
    }
}
