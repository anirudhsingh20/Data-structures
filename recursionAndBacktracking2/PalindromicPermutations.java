package recursionAndBacktracking2;

import java.util.Scanner;
import java.util.HashMap;

public class PalindromicPermutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }
        }

        Character oddChar = null;
        int odds = 0;
        int len = 0;
        for (Character key : hm.keySet()) {
            int freq = hm.get(key);
            if (freq % 2 == 1) {
                oddChar = key;
                odds++;
            }
            hm.put(key, freq / 2);
            len += freq / 2;
        }

        if (odds > 1) {
            System.out.println(-1);
            return;
        } else {
            printPermutations(1, len, hm, oddChar, "");
        }

    }

    static void printPermutations(int cs, int ts, HashMap<Character, Integer> hm, Character oddChar, String asf) {

        if (cs > ts) { // current spot > target spot
            String ans = asf;

            if (oddChar != null) {
                ans += oddChar;
            }
            for (int i = asf.length() - 1; i >= 0; i--) {
                ans += asf.charAt(i);
            }
            System.out.println(ans);
            return;
        }

        for (Character key : hm.keySet()) {
            int freq = hm.get(key);
            if (freq != 0) {
                hm.put(key, freq - 1);
                printPermutations(cs + 1, ts, hm, oddChar, asf + key);
                hm.put(key, freq);
            }
        }
    }
}
