package recursionAndBacktracking2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WordPatternMatching {
    public static void main(String[] args) {
        // INPUT:
        // graphtreesgraph
        // pep

        // OUTPUT: 
        // p -> graph, e -> trees, .

        // INPUT: 
        // mzaddytzaddy
        // abcb

        // OUTPUT:
        // a -> m, b -> zaddy, c -> t, .
        // a -> mz, b -> addy, c -> tz, .
        // a -> mza, b -> ddy, c -> tza, .
        // a -> mzad, b -> dy, c -> tzad, .
        // a -> mzadd, b -> y, c -> tzadd, .



        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.nextLine();
        sc.close();

        HashMap<Character, String> hm = new HashMap<>();

        printWordPatternMatching(str, pattern, hm, pattern);
    }

    static void printWordPatternMatching(String str, String pattern, HashMap<Character, String> hm, String originalPattern) {
        // base condition
        if (pattern.length() == 0) { 
            if (str.length() == 0) {
                HashSet<Character> set = new HashSet<>(); // to keep a count of charachters that are printed.

                for (int i = 0; i < originalPattern.length(); i++) {
                    char ch = originalPattern.charAt(i);
                    if (!set.contains(ch)) {
                        System.out.print(ch + " -> " + hm.get(ch) + ", ");
                        set.add(ch);
                    }
                }
                System.out.println(".");
            }
            return;
        }

        char ch = pattern.charAt(0);
        String rop = pattern.substring(1); // rest of the pattern

        if (hm.containsKey(ch)) {
            String previousMapping = hm.get(ch);

            if (previousMapping.length() <= str.length()) {
                String left = str.substring(0, previousMapping.length());
                String right = str.substring(previousMapping.length());

                if (previousMapping.equals(left)) {
                    printWordPatternMatching(right, rop, hm, originalPattern);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);

                hm.put(ch, left);
                printWordPatternMatching(right, rop, hm, originalPattern);
                hm.remove(ch);
            }
        }
    }
}
