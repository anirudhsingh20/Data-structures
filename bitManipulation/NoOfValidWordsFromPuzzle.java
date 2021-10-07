package bitManipulation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NoOfValidWordsFromPuzzle {
    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hm.put((char) ('a' + i), new ArrayList<>());
        }

        for (String word : words) {
            int mask = 0;

            for (int i = 0; i < word.length(); i++) {
                int bit = word.charAt(i) - 'a';
                mask = mask | (1 << bit);
            }

            HashSet<Character> unique = new HashSet<Character>();

            for (char ch : word.toCharArray()) {
                if (unique.contains(ch)) {
                    continue;
                }

                unique.add(ch);
                hm.get(ch).add(mask);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (String puzzle : puzzles) {
            int pmask = 0;

            for (int i = 0; i < puzzle.length(); i++) {
                int bit = puzzle.charAt(i) - 'a';
                pmask = pmask | (1 << bit);
            }

            char fch = puzzle.charAt(0);
            ArrayList<Integer> wordsMaskToCheck = hm.get(fch);
            int counter = 0;
            for (Integer wmask : wordsMaskToCheck) {
                if ((wmask & pmask) == wmask) {
                    counter++;
                }
            }
            ans.add(counter);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }

        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0; i < m; i++) {
            puzzles[i] = scn.next();
        }
        scn.close();

        ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }
}
