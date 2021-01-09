/*

Longest Palindrome in a String  ---- using brute force approach
-------------------------------------------------------
Given a string S, find the longest palindromic substring in S. 
Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. 
Incase of conflict, return the substring which occurs first ( with the least starting index ).
Example:
Input:
1
aaaabbaa

Output:
aabbaa
*/


package strings;

// import java.util.Scanner;

public class LongestPalindromeInAString {
    
    static String longestPalindrome(String s) {

        int n = s.length();

        int maxLength = 1, start = 0;

        boolean flag = true;

        for(int i = 0;i <n;i++){
            for(int j= i;j<n;j++){

                flag = true;
                for(int k=0;k < (j-i+1)/2; k++) {
                    if(s.charAt(i+k) != s.charAt(j-k))
                     {
                         flag = false;
                         break;
                     }
                }
                if(flag && (j-i+1)> maxLength) {
                    start = i;
                    maxLength = j-i+1;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
    public static void main (String args[]) {

        System.out.println(longestPalindrome("aaabbaa"));
        // Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// sc.nextLine();
		// for(int i=1; i <= n; i++){
        //     String str = sc.nextLine();
        //     String s = longestPalindrome(str);
		//     System.out.println(s);
		// }
    }
}
