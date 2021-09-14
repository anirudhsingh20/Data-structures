package stack;

import java.util.Stack;

public class LargestAreaHIstogram {

    public static void main(String[] args) {

        int arr[] = { 6, 2, 5, 4, 5, 1, 6 };

        int lb[] = new int[arr.length]; // index of smallest element to the left;

        // LOGIC TO FIND SMALLEST ELEMENT ON THE LEFT
        Stack<Integer> st = new Stack<>();
        st.push(0);
        lb[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }

        // LOGIC 2;
        // st.push(arr.length - 1);
        // for (int i = arr.length - 2; i >= 0; i--) {
        // while (st.size() > 0 && arr[i] < arr[st.peek()]) {
        // int pos = st.pop();
        // lb[pos] = i;
        // }
        // st.push(i);
        // }

        // while (st.size() > 0) {
        // int pos = st.pop();
        // lb[pos] = -1;
        // }

        int rb[] = new int[arr.length]; // index of smallest element to the right;

        // LOGIC TO FIND SMALLEST ELEMENT ON THE RIGHT
        st = new Stack<>();
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        // LOGIC 2;
        // st.push(0);
        // for (int i = 1; i < arr.length; i++) {
        // while (st.size() > 0 && arr[i] < arr[st.peek()]) {
        // int pos = st.pop();
        // rb[pos] = i;
        // }
        // st.push(i);
        // }

        // while (st.size() > 0) {
        // int pos = st.pop();
        // rb[pos] = arr.length;
        // }

        // OUTPUT STATEMENTS
        // for (int e : arr) {
        //     System.out.print(e + " ");
        // }
        // System.out.println();
        // for (int e : lb) {
        //     System.out.print((e) + " ");
        // }
        // System.out.println();
        // for (int e : rb) {
        //     System.out.print((e) + " ");
        // }

        // LOGIC TO CALC AREA
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * arr[i];

            // System.out.println("\n" + area);

            if (area > maxArea) {
                maxArea = area;
            }
        }
        System.out.println(maxArea);

    }
}
