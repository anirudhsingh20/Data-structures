package stack;
import java.util.*;

public class GreaterElementToRight {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,6,7};
        solve(arr);
    }

    private static void solve(int[] arr) {
        int nge[]= new int[arr.length]; // next greater element array

        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length - 1]);
        nge[arr.length - 1] = -1;

        for(int i = arr.length - 2; i >= 0 ; i--) {

            while(st.size() > 0 && st.peek() <= arr[i]) {
                st.pop();
            }
            if(st.size() == 0)
                nge[i] = -1;
            else 
                nge[i] = st.peek();
            
            st.push(arr[i]);
        }
        for (int e : nge) {
            System.out.print(e + " ");
        }
    }
}
