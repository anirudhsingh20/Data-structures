package recursionAndBacktracking2;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        // INPUT:
        // 11
        // i like pep coding pepper eating mango man go in pepcoding
        // ilikepeppereatingmangoinpepcoding

        // OUTPUT:
        // i like pepper eating man go in pep coding
        // i like pepper eating man go in pepcoding
        // i like pepper eating mango in pep coding
        // i like pepper eating mango in pepcoding
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dict.add(scn.next());
        }
        String sentence = scn.next();
        scn.close();
        wordBreak(sentence, "", dict);
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);

            if (dict.contains(left)) {
                wordBreak(right, ans + left + " ", dict);
            }

        }
    }
}
