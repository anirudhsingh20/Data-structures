package recursionAndBacktracking2;

import java.util.Scanner;

public class Permutaion_2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        int r = Integer.parseInt(sc.nextLine());

        sc.close();

        int boxes[] = new int[n];

        permutation(1, n, boxes, 0, r, "");

    }

    public static void permutation(int cb, int tb, int[] boxes, int ssf, int ts, String ans){

        if(cb > tb){
            if(ts == ssf){
                System.out.println(ans);
            }
            return;
        }

        for(int i= 0; i < ts; i++){
            if(boxes[i] == 0){
                boxes[i] = 1;// 1 means used;
                permutation(cb + 1, tb, boxes, ssf + 1, ts, ans + (i + 1));
                boxes[i] = 0;
            }
        }
        permutation(cb + 1, tb, boxes, ssf, ts, ans + 0);
    }
}
