package recursionAndBacktracking2;

import java.util.Scanner;

public class Combination_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int r = Integer.parseInt(sc.nextLine());
        sc.close();
        combination(new boolean[n], 1, r, -1);


    }

    public static void combination(boolean boxes[], int ci, int ti, int llb){ // llb -> last level box

        if(ci > ti){
            for(boolean e: boxes){
                if(e){
                    System.out.print("i");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }

        for(int i = llb + 1; i < boxes.length; i++){
            if(!boxes[i]){
                boxes[i] = true;
                combination(boxes, ci + 1, ti, i);
                boxes[i] = false;
            }
        }
    }
}
