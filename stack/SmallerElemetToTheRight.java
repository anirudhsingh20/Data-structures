package stack;

import java.util.Stack;

public class SmallerElemetToTheRight {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 68, 8 };

        int nse[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
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
