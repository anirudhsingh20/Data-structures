package stack;

import java.util.Stack;

public class SmallerElementToTheLeft {

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 9, 10 };
        int arr[] = { 11, 2, 5, 8, 5, 2, 8, 2, 8, 5, 4, 6 };
        int nge[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for (int i = 0; i < arr.length ; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if(st.size()>0){
                nge[i] = st.peek();
            }
            else{
                nge[i] = -1;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int pos = st.pop();
            nge[pos] = -1;
        }

        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (int e : nge) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (int e : nge) {
            System.out.print((e < 0 ? e : arr[e]) + " ");
        }
    }
}
