package sorting;

public class QuickSortUsingFirstElementAsPivot {

    public static int partion(int arr[],int l, int h) {

        int pivot = arr[l];
        int i = h+1;

        for(int j = h; j>l; j--) {
            if(arr[j]>pivot){
                i--;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i-1];
        arr[i-1] = arr[l];
        arr[l] = temp;

        return i-1;
    }
    

    public static void quickSort(int arr[],int l, int h) {

        if(l<h)
        {
            int pi = partion(arr,l,h);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,h);
        }
    }
    public static void main(String[] args) {
        int arr[] = {38, 27, 43, 3, 9, 82, 10,-1000,67,-9};

        quickSort(arr,0,arr.length-1);

        // print sorted array
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
