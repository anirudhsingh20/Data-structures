package recursionAndBacktracking2;

import java.util.HashMap;
import java.util.Scanner;

public class PermutationWord2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        HashMap<Character, Integer> lastOccurenceMap = new HashMap<>();

        // add -1 to all keys
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            lastOccurenceMap.put(ch, -1);  
        }

        permutation(0, lastOccurenceMap, new Character[str.length()], str);
    }

    static void permutation(int cl, HashMap<Character, Integer> lastOccurenceMap, Character spots[], String str){

        if(cl == str.length()){
            for(int i = 0; i < spots.length; i++){
                System.out.print(spots[i]);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(cl);
        int lastOccurence = lastOccurenceMap.get(ch);

        for(int i = lastOccurence + 1; i < str.length(); i++ ){
            if(spots[i] == null){
                spots[i] = ch;
                lastOccurenceMap.put(ch, i);
                permutation(cl + 1, lastOccurenceMap, spots, str);
                lastOccurenceMap.put(ch, -1);
                spots[i] = null;
            }
        }
    }
}
