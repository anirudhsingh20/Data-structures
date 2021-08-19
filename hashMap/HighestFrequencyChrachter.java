package hashMap;

import java.util.HashMap;

public class HighestFrequencyChrachter {

    static char highestFrequencyChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();

        char charMax = str.charAt(0);
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (hm.get(c) != null) {
                int val = hm.get(c) + 1;

                if (val > max) {
                    max = val;
                    charMax = c;
                }

                hm.put(c, val);
            } else {
                hm.put(c, 1);
                if (max == 0) {
                    max = 1;
                    charMax = c;
                }
            }
        }
        return charMax;
    }

    public static void main(String[] args) {
        String str = "babccpcpbpbpbpp";
        System.out.println(highestFrequencyChar(str));
    }
}
