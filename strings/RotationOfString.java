package strings;

public class RotationOfString {
    public static void main (String args[]) {

        // 1st approach 

        String s1 = "ABCD";
        String s2 = "CDAB";
        String temp = s1 + s1;

        if(s1.length() == s2.length() && temp.indexOf(s2) != -1 ) {
            System.out.println("string 1 is rotation of string 2");
        }
        else {
            System.out.println("string 1 is not rotation of string 2");
        }

        
    }
}