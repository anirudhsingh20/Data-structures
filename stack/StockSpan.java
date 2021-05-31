package stack;

import java.util.Stack;

class StockSpan {
    // similar to next greater element to the left

    public static void main(String[] args) {

        int arr[] = {1,0,3,4,5,6,1};

        int span[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        span[0] = 1;
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                span[i] = i + 1;
            else
                span[i] = i - st.peek();

            st.push(i);
        }

        for (int e : span) {
            System.out.print(e + ", ");
        }

    }
}