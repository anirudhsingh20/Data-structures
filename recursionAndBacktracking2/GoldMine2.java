package recursionAndBacktracking2;

import java.util.ArrayList;
import java.util.Scanner;

public class GoldMine2 {
    static int max = 0;

    public static void getMaxGold(int[][] arr) {
        // write your code here
        max = 0;
        boolean isVisited[][] = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0 && isVisited[i][j] == false) {
                    ArrayList<Integer> bag = new ArrayList<>();
                    int sum = 0;

                    travelAndCollectGold(arr, i, j, isVisited, bag);

                    for(int e:bag){
                        sum+= e;
                    }
                    if(sum>max){
                        max = sum;
                    }
                }
            }
        }
    }

    static void travelAndCollectGold(int arr[][], int r, int c, boolean isVisited[][], ArrayList<Integer> bag) {
        //base condition
        if(r < 0 || c < 0 || r >=arr.length || c >= arr[0].length || arr[r][c] == 0 || isVisited[r][c] == true){
            return;
        }

        isVisited[r][c] = true;
        bag.add(arr[r][c]);

        travelAndCollectGold(arr, r - 1, c, isVisited, bag); // top
        travelAndCollectGold(arr, r, c - 1, isVisited, bag); // left
        travelAndCollectGold(arr, r + 1, c, isVisited, bag); // bottom
        travelAndCollectGold(arr, r, c + 1, isVisited, bag); // right
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
        scn.close();
    }

}
