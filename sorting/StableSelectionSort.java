package sorting;

public class StableSelectionSort {
    
    public static void sort(int arr[]) {
        int n = arr.length;

        for(int i = 0; i<n; i++) {

            // to find minimum element index
            int min_idx = i;
            for(int j = i+1; j<n; j++){
                if(arr[min_idx] > arr[j])
                    min_idx = j;
            }

            // swap till minimum element of the array till min index 
            // (sorted side : left side of the array) that is i
            while(min_idx > i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[min_idx-1];
                arr[min_idx-1] = temp;

                min_idx--;

            }
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
