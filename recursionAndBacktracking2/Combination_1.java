package recursionAndBacktracking2;

import java.util.Scanner;

public class Combination_1 {
    public static void combinations(int cb, int tb, int ssf, int ts, String asf){

        if(cb > tb){
            if(ssf == ts){
                System.out.println(asf);
            }
            return;
        }

        combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
        combinations(cb + 1, tb, ssf, ts, asf + "-"); 
    }
    
      public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nboxes = Integer.parseInt(sc.nextLine());
        int ritems = Integer.parseInt(sc.nextLine());
        sc.close();

        combinations(1, nboxes, 0, ritems, "");
      }
}
