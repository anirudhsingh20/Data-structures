/*
Searching in an array where adjacent differ by at most k

A step array is an array of integer where each element has a difference of at most k with its neighbor. 
Given a key x, we need to find the index value of x if multiple element exist return the first occurrence of the key.

Examples:

        Input : arr[] = {4, 5, 6, 7, 6}
                k = 1
                x = 6
        Output : 2
        The first index of 6 is 2.

        Input : arr[] = {20, 40, 50, 70, 70, 60}  
                k = 20
                x = 60
        Output : 5
        The index of 60 is 5

*/


package searching;

public class SearchInAnArrayWhereAdjacentDifferByAtMostK {
    
    public static void main (String args[]) {
        
        int arr[] = {20, 40, 50, 70, 70, 60};
        int i=0, k=20, x = 60,n = arr.length,idx=-1;

        while(i<n){

            if(arr[i]==x){
                idx = i;
                break;
            }

            i += Math.max(1, Math.abs(arr[i]-x)/k);

        }
        System.out.println(idx);
    }
}
