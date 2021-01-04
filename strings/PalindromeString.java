// Given a string S, check if it is palindrome or not.

// Example 1:

// Input: S = "abba"
// Output: 1
// Explanation: S is a palindrome

package strings;

public class PalindromeString {

    public static int isPalindrome(String S) {
        // code here
        
        char[] s = S.toCharArray();
        
        int left = 0, right = s.length-1;
        while(left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        String str = new String(s);
        
        return S.equals(str) ? 1: 0;
    }
    
    public static void main(String args[]) {

        String string = "abba";
        System.out.println(isPalindrome(string));
    }
}
