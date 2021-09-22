package recursionAndBacktracking2;

import java.util.*;

public class PermutationsWord1 {
    
  public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
    // write your code here
    if(cs > ts){
        System.out.println(asf);
        return;
    }
    

    for(Character ch : fmap.keySet()){
        int freq = fmap.get(ch);
        if(fmap.get(ch) > 0){
            fmap.put(ch, freq - 1);
            generateWords(cs + 1, ts, fmap, asf + ch);
            fmap.put(ch, freq);
        }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    sc.close();

    HashMap<Character, Integer> fmap = new HashMap<>();
    for(char ch: str.toCharArray()){
      if(fmap.containsKey(ch)){
        fmap.put(ch, fmap.get(ch) + 1);
      } else {
        fmap.put(ch, 1);
      }
    }

    generateWords(1, str.length(), fmap, "");
  }
}
