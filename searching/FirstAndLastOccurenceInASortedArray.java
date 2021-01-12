package searching;

public class FirstAndLastOccurenceInASortedArray {
    
    public static int first(int arr[],int low, int high,int x ,int n){

        if(low <= high) {

            int mid = low + (high - low)/2;

            if((mid == 0 || x > arr[mid-1]) && arr[mid]== x)
                return mid;
            else if (arr[mid]< x) 
                return first(arr,(mid+1),high,x,n);
            else 
                return first(arr,low,(mid -1),x,n);

        }
        return -1;
    }
    public static int last(int arr[],int low, int high,int x ,int n){

        if(low <= high) {

            int mid = low + (high - low)/2;

            if((mid == n-1 || x < arr[mid+1]) && arr[mid]== x)
                return mid;
            else if (arr[mid]> x) 
                return last(arr,low,(mid -1),x ,n);
            else 
                return last(arr,(mid+1),high,x,n);
            
        }
        return -1;
    }
    public static void main(String args[]) {

        int arr[]= {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int n = arr.length;
        int x = 5;
        System.out.println(first(arr, 0, n-1, x, n));
        System.out.println(last(arr, 0, n-1, x, n));


    }
}
