package recursionAndBacktracking2;

import java.util.Scanner;

public class Permutation_1 {
    public static void permutations(int[] boxes, int ci, int ti) {

        if(ci > ti){
            for(int e : boxes){
                System.out.print(e);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i] == 0){
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nboxes = Integer.parseInt(sc.nextLine());
        int ritems = Integer.parseInt(sc.nextLine());
        sc.close();
        permutations(new int[nboxes], 1, ritems);
    }
}
