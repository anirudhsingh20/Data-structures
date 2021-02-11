package recursion;

public class TargetSumSubset {
    
 public static void main(String[] args) {
    int arr[] = {10, 20, 30, 40 ,50 ,60};
    int x = 60;
    targetSumSubset(arr, 0, x,0, "");
 }

 private static void targetSumSubset(int[] arr, int index, int target, int sos , String ans) {

    if(index >= arr.length) 
        return;
    else {

        if(sos == target) {
            System.out.print(ans + " | ");
            return;
        }

        targetSumSubset(arr, index + 1, target, sos + arr[index], ans + " " +  arr[index]);
        targetSumSubset(arr, index + 1, target, sos, ans);
       
    }

 }
}
