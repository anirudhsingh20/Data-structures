package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingIntervals {

    static class Pair implements Comparable<Pair> {
        int st;
        int end;

        Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair o) {
            return this.st - o.st;
        }
    }

    static void merge(int arr[][]) {
        // we already know each row has 2 cols

        int n = arr.length;

        Pair pairs[] = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        // sort all intervals w.r.t start time
        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);

        for (int i = 1; i < arr.length; i++) {
            if (st.peek().end < pairs[i].st) {
                st.push(pairs[i]);
            } else {
                st.peek().end = Math.max(st.peek().end, pairs[i].end);
            }
        }

        Stack<Pair> rs = new Stack<>();

        while (st.size() > 0) {
            rs.push(st.pop());
        }

        System.out.println("Merged Intervals;");

        while (rs.size() > 0) {
            Pair p = rs.pop();
            System.out.println(p.st + " - " + p.end);
        }

    }

    public static void main(String[] args) {
        // INPUT:
        // 6
        // 22 28
        // 1 8
        // 25 27
        // 14 19
        // 27 30
        // 5 12

        // OUTPUT:
        // Merged Intervals;
        // 1 - 12
        // 14 - 19
        // 22 - 30
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = sc.nextLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }
        sc.close();

        merge(arr);
    }
}
