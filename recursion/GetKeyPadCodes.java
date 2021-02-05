package recursion;

import java.util.ArrayList;

public class GetKeyPadCodes {
    public static void main(String[] args) {

        ArrayList<String> result = getKPC("573");  // input 573
        int resultSize = result.size();

        System.out.println(result);
        System.out.println("Size :" + resultSize);
    }
    // Key Pad Codes
    public static String[] codes = {",;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getKPC(String str) {   // input 573

        // base condition
        if(str.length() == 0) {
            ArrayList<String> emptyResult = new ArrayList<>();
            emptyResult.add("");
            return emptyResult; // return [""]
        }


        char ch = str.charAt(0); // 5
        String subStr = str.substring(1); //73

        ArrayList<String> prevRes = getKPC(subStr);   // return all possible combination of 73 

        ArrayList<String> res = new ArrayList<>();   // to store result

        String c = codes[ch - 48];  // get string from entered number
        for(int i = 0; i< c.length(); i++)
        {
            for (String string : prevRes) 
            {
                res.add(c.charAt(i) + string);
            } 
        }
        return res;
    }
}
