package searching;

public class BinarySearch {

    public static int binarySearch(int arr[], int e) {
        if(arr.length == 1)
            return arr[0] == e ? 1: -1;
        
        int left = 0;
        int right = arr.length -1;
        int mid = (left + right)/2;

        while(left<=right) {
            if(arr[mid]== e)
                return mid;
            else if(arr[mid]< e)
                left = mid + 1;
            else 
                right = mid - 1;

            mid = (left+right)/2;
        }
        // if(arr[mid]==e){
        //     return mid;
        // }
        return -1;
    }
    
    public static void main(String args[]) {

        int arr[] = {1,2,3,4,5,6,7,8};
        int e = 3;

        System.out.println("\nIndex of Element: " + binarySearch(arr, e));
    }
}
