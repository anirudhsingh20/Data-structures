package sorting;

public class InsertionSort {

    static void sort(int arr[]) {
        int n = arr.length;

        for(int i = 0 ; i<n-1 ;i++) {
            for(int j = i+1 ; j>0; j--){
                
                if(arr[j-1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
    
    public static void main(String[] args) {
        
        int arr[] = {3,4,12,5,6,7,1};

        sort(arr);
    }
}
