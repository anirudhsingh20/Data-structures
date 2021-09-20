package recursionAndBacktracking2;

import java.util.*;

public class FindMaxWithKSwaps {

    static String max;

    public static void findMaximum(String str, int k) {

        if (Integer.parseInt(max) < Integer.parseInt(str)) {
            max = str;
        }

        if (k == 0) {
            return;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    str = swap(str, i, j);
                    findMaximum(str, k - 1);
                    str = swap(str, i, j);
                }
            }
        }

    }

    static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1);

        return left + jth + middle + ith + right;
    }

    public static void main(String[] args) {
        // INPUT:
        // 1234567
        // 4

        // OUTPUT:
        // 7654312
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        sc.close();

        max = str;
        findMaximum(str, k);
        System.out.println(max);
    }
}
