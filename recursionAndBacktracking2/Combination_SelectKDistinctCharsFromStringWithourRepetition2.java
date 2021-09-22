package recursionAndBacktracking2;

import java.util.*;

public class Combination_SelectKDistinctCharsFromStringWithourRepetition2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());
        sc.close();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        generateSelection(-1, ustr, 0, k, "");

    }
    public static void generateSelection(int lc, String ustr, int ssf, int ts, String ans){

        if(ssf == ts){
            System.out.println(ans);
            return;
        }

        for(int i = lc + 1; i< ustr.length(); i++){
            char ch = ustr.charAt(i);
            generateSelection(i, ustr, ssf + 1, ts, ans + ch);
        }
    }
}
