// Write a function that reverses a string. 
//The input string is given as an array of characters char[].

/*
Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/
package strings;

public class ReverseAString {

    public static void reverse(char[] s) {

        int left = 0 , right = s.length -1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }

        for(char c : s) 
         System.out.print(c + " ");
    }

    public static void main(String args[]) {
        String str = "hello";

        reverse(str.toCharArray());
        
    }
    
}
