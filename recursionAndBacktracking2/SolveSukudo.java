package recursionAndBacktracking2;

import java.util.Scanner;

public class SolveSukudo {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] board, int i, int j) {

        if (i == board.length) {
            display(board);
            return;
        }

        // write yopur code here
        int ni = 0;
        int nj = 0;

        if (j == board.length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }
        if (board[i][j] != 0) {
            solveSudoku(board, ni, nj);
        } else {
            for (int po = 1; po <= 9; po++) { // posible option
                if (isValidValue(board, i, j, po))
                {
                    board[i][j] = po;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isValidValue(int[][] board, int i, int j, int po) {

        for (int k = 0; k < board.length; k++) {
            if (board[i][k] == po) {
                return false;
            }
        }

        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == po) {
                return false;
            }
        }

        int smi = i / 3 * 3; // start matrix i
        int smj = j / 3 * 3; // start of matrix j
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[smi + x][smj + y] == po) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println();
        solveSudoku(arr, 0, 0);
        scn.close();
    }
}
