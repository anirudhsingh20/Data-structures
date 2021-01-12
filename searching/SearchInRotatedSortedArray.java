package searching;

public class SearchInRotatedSortedArray {

    static int search(int arr[],int low, int high,int x,int n){


        while(low<= high) 
        {

            int mid = low + (high -low)/2;

            if(arr[mid] == x) {
                return mid;
            }
            
            if(arr[low]<= arr[mid]) {

                if(x < arr[mid] && x >= arr[low]){
                    high = mid-1;
                }
                else {
                    low = mid +1;
                }
            }

            else if(arr[mid] <= arr[high]) {
                if(x > arr[mid] && x <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid -1;
                }
            }

        }
        return -1;
    }
    
    public static void main(String args[]){

        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,0,nums.length -1, target, nums.length));
    }
}


