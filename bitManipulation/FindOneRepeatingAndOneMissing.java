package bitManipulation;

import java.util.Scanner;

public class FindOneRepeatingAndOneMissing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        solution(arr);
    }

    public static void solution(int[] arr) {
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }

        for (int i = 1; i <= arr.length; i++) {
            xor ^= i;
        }

        int rsbm = (xor & -xor);
        int x = 0;
        int y = 0;

        for (int e : arr) {
            if ((rsbm & e) == 0) {
                x ^= e;
            } else {
                y ^= e;
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if ((i & rsbm) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for (int e : arr) {
            if (e == x) {
                System.out.println("Missing Number" + " -> " + y);
                System.out.println("Repeating Number" + " -> " + x);
                break;
            } else if (e == y) {
                System.out.println("Missing Number" + " -> " + x);
                System.out.println("Repeating Number" + " -> " + y);
                break;
            }
        }

    }
}
