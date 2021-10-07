package bitManipulation;

import java.util.*;

public class Triplets_1 {
    public static void solution(int[] arr) {

        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                val ^= arr[k];

                if (val == 0) {
                    c += (k - i);
                }
            }
        }

        System.out.println(c);

    }

    public static void main(String[] args) {
        // Input:
        // 3
        // 1 2 3
        // Output:
        // 2
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        solution(arr);
    }
}
