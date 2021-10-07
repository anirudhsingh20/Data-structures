package bitManipulation;

import java.util.Scanner;

public class AllRepeatingThreeTimesExceptOne {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();


        solution(arr);
    }

    public static void solution(int[] arr) {

        int threeN = Integer.MAX_VALUE, threeNPlusOne = 0, threeNPlusTwo = 0;

        for(int i = 0 ; i < arr.length ; i++){
            int cwthreeN = threeN & arr[i];
            int cwthreeNPlusOne = threeNPlusOne & arr[i];
            int cwthreeNPlusTwo = threeNPlusTwo & arr[i];

            threeN &= (~cwthreeN);
            threeNPlusOne |= cwthreeN;
            
            threeNPlusOne &= (~cwthreeNPlusOne);
            threeNPlusTwo |= cwthreeNPlusOne;
            
            threeNPlusTwo &= (~cwthreeNPlusTwo);
            threeN |= cwthreeNPlusTwo;
        }

        System.out.println(threeNPlusOne);

    }
}
