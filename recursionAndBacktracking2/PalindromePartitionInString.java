package recursionAndBacktracking2;

import java.util.Scanner;

public class PalindromePartitionInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        // function call
        printAllPalindromicPartitions(str, "");

    }

    static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            char left = str.charAt(l);
            char right = str.charAt(r);

            if (left != right) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    static void printAllPalindromicPartitions(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1); // string from 0 to ith index
            String ros = str.substring(i + 1); // rest of the string;
            if (isPalindrome(prefix)) {
                printAllPalindromicPartitions(ros, asf + "(" + prefix + ") ");
            }
        }
    }
}
