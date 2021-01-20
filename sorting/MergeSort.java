package sorting;

public class MergeSort {

    public static void merge(int arr[], int l , int mid , int h) {

        int n1 = mid - l + 1; //
        int n2 = h - mid; // 

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = 0; i<n1; i++)
            L[i] =arr[l+i];
        for(int j = 0; j<n2; j++)
            R[j] = arr[mid+1+j];

        int i = 0;

        int j = 0;

        int k = l;

        while(i<n1 && j<n2) {
            if(L[i]<=R[j]){
                arr[k++] = L[i++];
            }
            else{
                arr[k++] = R[j++];
            }
        }
        while( i<n1){
            arr[k++] = L[i++];
        }
        while( j<n2){
            arr[k++] = R[j++];
        }
    }


    public static void mergeSort(int arr[],int l ,int h) {

        if(l<h){
            int mid = (l+h)/2; //3
            mergeSort(arr, l, mid); //0123
            mergeSort(arr, mid+1, h); // 4567
            merge(arr,l,mid,h);
        }
    }

    public static void main(String[] args) {
        
        int arr[] = {38, 27, 43, 3, 9, 82, 10,-1000,67,-9};

        // print given array
        System.out.println("\nSorted array: ");
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        mergeSort(arr,0,arr.length-1);
        
        // print sorted array
        System.out.println("Sorted array: ");
        for (int e : arr) {
            System.out.print(e+ " ");
        }
    }
}
