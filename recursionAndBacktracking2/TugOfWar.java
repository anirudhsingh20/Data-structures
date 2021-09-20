package recursionAndBacktracking2;

import java.util.ArrayList;
import java.util.Scanner;

public class TugOfWar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        sc.close();
        
        findMinimumSubsetDifference(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println(ans);

    }
    static int minDifference= Integer.MAX_VALUE;
    static String ans = "";
    static void findMinimumSubsetDifference(int arr[], int idx, ArrayList<Integer> set1, ArrayList<Integer> set2, int set1Sum, int set2Sum){

        if(idx == arr.length){
            int diff = Math.abs(set1Sum - set2Sum);
            if(diff < minDifference){
                minDifference =diff;
                ans = set1 + " " + set2;
            }
        }

        if(set1.size() < (arr.length + 1) / 2){
            set1.add(arr[idx]);
            set1Sum += arr[idx];
            findMinimumSubsetDifference(arr, idx + 1, set1, set2, set1Sum, set2Sum);
            set1.remove(set1.size() -1);
            set1Sum -= arr[idx];
        }

        if(set2.size() < (arr.length + 1) / 2){
            set2.add(arr[idx]);
            set2Sum += arr[idx];
            findMinimumSubsetDifference(arr, idx + 1, set1, set2, set1Sum, set2Sum);
            set2.remove(set2.size() -1);
            set2Sum -= arr[idx];
        }
    }
}
