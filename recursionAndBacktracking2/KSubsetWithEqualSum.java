package recursionAndBacktracking2;

import java.util.ArrayList;
import java.util.Scanner;

public class KSubsetWithEqualSum {
    public static void main(String[] args) {
        // INTPUT:
        // 6
        // 1
        // 2
        // 3
        // 4
        // 5
        // 6
        // 3

        // OUTPUT
        // [1, 6] [2, 5] [3, 4
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        int sum = 0;

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
            sum += arr[i];
        }

        int k = Integer.parseInt(sc.nextLine());

        if (k == 1) {
            for (int e : arr) {
                System.out.println(e);
            }
        } else if (k > n || sum % k != 0) {
            System.out.println(-1);
            return;
        } else {
            int subsetSum[] = new int[k];
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                ans.add(new ArrayList<>());
            }

            findKSubsetWithEqualSum(arr, 0, n, k, 0, subsetSum, ans);
        }
    }

    static void findKSubsetWithEqualSum(int arr[], int idx, int n, int k, int ssssf, int subsetSum[],
            ArrayList<ArrayList<Integer>> ans) {

        if (idx == n) {
            if (ssssf == k) {
                boolean flag = true;

                // checks all sum are equal or not
                for (int i = 0; i < subsetSum.length - 1; i++) {
                    if (subsetSum[i] != subsetSum[i + 1]) {
                        flag = false;
                    }
                }

                if (flag) {
                    for (ArrayList<Integer> subsetList : ans) {
                        System.out.print(subsetList + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        // partition logic with subset sum
        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() == 0) {
                subsetSum[j] += arr[idx];
                ans.get(j).add(arr[idx]);

                findKSubsetWithEqualSum(arr, idx + 1, n, k, ssssf + 1, subsetSum, ans);

                ans.get(j).remove(ans.get(j).size() - 1);
                subsetSum[j] -= arr[idx];
                
                break; // !important 

            } else {
                subsetSum[j] += arr[idx];
                ans.get(j).add(arr[idx]);

                findKSubsetWithEqualSum(arr, idx + 1, n, k, ssssf, subsetSum, ans);

                ans.get(j).remove(ans.get(j).size() - 1);
                subsetSum[j] -= arr[idx];
            }
        }

    }
}
