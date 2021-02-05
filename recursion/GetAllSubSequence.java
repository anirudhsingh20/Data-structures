package recursion;

import java.util.ArrayList;

public class GetAllSubSequence {
    
    public static void main(String[] args) {
        String  s = "abc";
        ArrayList<String> subSequences = getAllSubSequence(s);
        System.out.println(subSequences);
    }

    private static ArrayList<String> getAllSubSequence(String s) {
        if(s.length() == 0) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add("");
            return temp;
        }
        char ch = s.charAt(0);
        
        String tempSubStr = s.substring(1);
        ArrayList<String> list = getAllSubSequence(tempSubStr);

        ArrayList<String> res = new ArrayList<>();
        
        for (String string : list) {
                res.add("" + string);
        }
        for (String string : list) {
            res.add(ch + string);
        }
        return res;
    }
}
