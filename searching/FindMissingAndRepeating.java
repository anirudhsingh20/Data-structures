package searching;

public class FindMissingAndRepeating {

     static void findTwoElement(int arr[], int n) {
        // code here
        
        for(int i=0;i<n;i++){
            int abs = Math.abs(arr[i]);
            if(arr[abs - 1]>0)
                arr[abs -1] = -arr[abs -1];
            else
             System.out.println(abs);
        }
        int idx = 0; 
        for(int e: arr){
            if(e > 0)
                System.out.println(idx + 1);
            idx++;
        }
    }
    public static void main(String args[]) {

        int arr[] = {1, 3, 3};

        findTwoElement(arr, arr.length);
    }
}