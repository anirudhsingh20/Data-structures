package recursion;

public class AllIndicesInAnArray {
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,6,5,4,3,2,1,2,3,56,1};
        int allIndices[] = displayAllIndices(arr, 0 , 2, 0);

        for (int e : allIndices) {
            System.out.print(e + " ");
        }
    }

    static int[] displayAllIndices(int arr[],int i, int x , int fsf){ // found so far

        if(arr.length == i) 
            return new int[fsf];

        if(arr[i] == x) {
            int iarr[] = displayAllIndices(arr, i+1, x, fsf+1);
            iarr[fsf] = i;
            return iarr;
        }
        else {
            // int iarr[] = displayAllIndices(arr, i+1, x, fsf);
            // return iarr; 
            // OR
           return displayAllIndices(arr, i+1, x, fsf);
        }
    }
}
