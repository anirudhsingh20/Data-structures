package graph;

import java.util.Scanner;

public class GetNoOfIsland {

    static void getNoOfIsland(int arr[][], int i, int j, boolean[][] isVisited) {

        // reactive approach
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || isVisited[i][j] || arr[i][j] == 1) {
            return;
        }
        isVisited[i][j] = true;

        // check left right top bottom for 0 (0 means land)
        getNoOfIsland(arr, i, j - 1, isVisited); // left
        getNoOfIsland(arr, i, j + 1, isVisited); // right
        getNoOfIsland(arr, i - 1, j, isVisited); // top
        getNoOfIsland(arr, i + 1, j, isVisited); // bottom
    }

    public static void main(String[] args) {
        // INPUT:
        // 8
        // 8
        // 0 0 1 1 1 1 1 1
        // 0 0 1 1 1 1 1 1
        // 1 1 1 1 1 1 1 0
        // 1 1 0 0 0 1 1 0
        // 1 1 1 1 0 1 1 0
        // 1 1 1 1 0 1 1 0
        // 1 1 1 1 1 1 1 0
        // 1 1 1 1 1 1 1 0

        // OUTPUT
        // No. of Islands: 3

        Scanner sc = new Scanner(System.in);

        int r = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        int arr[][] = new int[r][c];

        for (int i = 0; i < r; i++) {
            String[] vals = sc.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(vals[j]);
            }
        }
        sc.close();
        boolean isVisited[][] = new boolean[r][c];
        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0 && !isVisited[i][j]) {
                    getNoOfIsland(arr, i, j, isVisited);
                    count++;
                }
            }
        }
        System.out.println("No. of Islands: " + count);

    }
}
