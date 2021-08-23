package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedList {

    static class Pair implements Comparable<Pair> {

        int li; // list index
        int di; // data index
        int val;

        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    static ArrayList<Integer> sort() {

        // take input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of lists");
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> list = new ArrayList<>();
            String[] arr = sc.nextLine().split(" ");
            for (int j = 0; j < len; j++) {
                list.add(Integer.parseInt(arr[j]));
            }
            lists.add(list);
        }
        sc.close();

        // Logic

        // Sorted List
        ArrayList<Integer> sortedList = new ArrayList<>();

        // create priority queue and add all the first elements of each sorted list to
        // queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }

        while (pq.size() > 0) {
            Pair p = pq.remove();
            sortedList.add(p.val);
            p.di++;

            if (p.di < lists.get(p.li).size()) {
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return sortedList;
    }

    public static void main(String[] args) {
        System.out.println(sort());
    }
}
