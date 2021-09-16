package recursionAndBacktracking2;

import java.util.ArrayList;
import java.util.Scanner;

public class Kpartitions {

    static int counter = 1;

    public static void main(String[] args) {
        // INPUT:
        // 4
        // 3
        
        // OUTPUT:
        // 1. [1, 2] [3] [4]
        // 2. [1, 3] [2] [4]
        // 3. [1] [2, 3] [4]
        // 4. [1, 4] [2] [3]
        // 5. [1] [2, 4] [3]
        // 6. [1] [2] [3, 4]
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        sc.close();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<Integer>());
        }
        solve(1, n, k, 0, ans);
    }

    static void solve(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {

        if (i > n) {
            if (rssf == k) // result set/paritions so far
            {
                System.out.print(counter + ". ");
                for (ArrayList<Integer> set : ans) {
                    System.out.print(set + " ");
                }
                System.out.println();
                counter++;
            }

            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() == 0) {
                ans.get(j).add(i);
                solve(i + 1, n, k, rssf + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            } else {
                ans.get(j).add(i);
                solve(i + 1, n, k, rssf, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            }
        }
    }
}
