package stack;

import java.util.Stack;

public class GreaterElementToLeft {
    
    public static void main(String[] args) {
        int arr[] = { 10, 3, 4, 5, 68, 8 };

        int nse[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(arr.length-1);

        
        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                int pos = st.peek();
                nse[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while (st.size() > 0) {
            int pos = st.peek();
            nse[pos] = -1;
            st.pop();
        }

        for (int e : nse)
            System.out.print(e + ",");
        
    }
}
