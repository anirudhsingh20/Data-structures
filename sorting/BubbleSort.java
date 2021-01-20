package sorting;

public class BubbleSort {
    
    public static void sort(int arr[]){

        int n = arr.length;

        // to optimize the sort -> make best case O(n)
        boolean isSwap = false;
        for(int i=0; i<n-1; i++) {
            for(int j=1; j<n-i; j++){
                if(arr[j-1]>arr[j]){
                    // compare 2 element each time and so that after this loop 
                    // the largest element will take up its position at the end.
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    isSwap = true;
                }
            }
            // if there is no swap (in inner loop) break the outer loop
            if(!isSwap) break;
        }

        for(int e : arr)
            System.out.print(e + " ");

    }
    public static void main(String[] args) {
        
        int arr[]= {12,3,4,6,8,3,2,100,-1,4,6};

        sort(arr);
    }

    
}
