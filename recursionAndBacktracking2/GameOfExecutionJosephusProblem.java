package recursionAndBacktracking2;

import java.util.Scanner;

public class GameOfExecutionJosephusProblem {
    public static void main(String[] args) {
        // Input:
        // 4
        // 2
        // Output:
        // 0       (index value)

        // Input:
        // 8
        // 3
        // Output
        // 6
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n, k));
        scn.close();
    }

    private static int solution(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int x = solution(n - 1, k); // solution on n - 1
        int y = (x + k) % n;
        return y;
    }
}
