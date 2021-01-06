/*
    Java Program to Check if a string is a valid shuffle of two distinct strings

    ex.1 1XY2 is a valid shuffle of XY and 12
        Y12X is not a valid shuffle of XY and 12

    explaination : In the above example, we have a string array named results. It contains two strings: 1XY2 and Y12X. We are checking if these two strings are valid shuffle of strings first(XY) and second(12).

    Here, the program says 1XY2 is a valid shuffle of XY and 12. However, Y12X is not a valid shuffle.

    This is because Y12X has altered the order of string XY. Here, Y is used before X. Hence, to be a valid shuffle, the order of string should be maintained.

    ex. 2 
            String a = "AB";
            String b = "CD";
            String c = "ACBD";
*/

package strings;


// no common charachters
public class CheckIsInterleavingWithNoCommon {

    public static boolean isInterleaving(String a, String b, String c) {

        int i = 0, j = 0, k = 0;

        while (k < c.length()) {

            if(i<a.length() && a.charAt(i) == c.charAt(k))
                i++;
            else if (j<b.length() && b.charAt(j) == c.charAt(k))
                j++;
            else 
                return false;

            k++;    
        }

        if(i< a.length() || j < b.length())
            return false;


        return true;
    }
    
    public static void main(String args[]) {

        String a = "AB";
        String b = "CD";
        String c = "ACBD";

        System.out.println(isInterleaving(a,b,c));
    }
}
