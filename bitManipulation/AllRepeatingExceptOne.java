package bitManipulation;

import java.util.Scanner;

public class AllRepeatingExceptOne {

    public static void main(String[] args) {
        // INPUT:
        // 5
        // 23 27 23 17 17
        
        // OUTPUT:
        // 27
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        // logic
        int uni = 0;
        for (int e : arr) {
            uni ^= e;
        }
        System.out.println(uni);

    }

}
