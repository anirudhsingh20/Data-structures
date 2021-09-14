package stack;

import java.util.Stack;

public class CelebrityProblem {

    static void findCelebrity(int[][] arr) {
        int n = arr.length; // n*n matrix

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                // i knows j
                st.push(j);
            } else {
                // i doesn't know j
                st.push(i);
            }
        }

        int potentialCelebrity = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity) {
                if (arr[i][potentialCelebrity] == 0 || arr[potentialCelebrity][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potentialCelebrity);
    }

    public static void main(String[] args) {
        // INPUT NO. 1;
        // int arr[][] = 
        // { 
        //     { 0, 0, 0, 0 }, 
        //     { 1, 0, 1, 1 }, 
        //     { 1, 1, 0, 1 }, 
        //     { 1, 1, 1, 0 }, 
        // }; // op : 0

        int arr[][] = 
        { 
            { 0, 0, 0, 0 }, 
            { 1, 0, 1, 1 }, 
            { 0, 0, 0, 0 }, 
            { 1, 1, 1, 0 }, 
        }; // op : 2

        findCelebrity(arr);  // return index of celebrity
    }
}
