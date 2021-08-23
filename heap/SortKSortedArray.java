package heap;

import java.util.PriorityQueue;

public class SortKSortedArray {

    static void printSorted(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            System.out.print(pq.peek() + " ");
            pq.remove();
            pq.add(arr[i]);
        }

        while (pq.size() > 0) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }

    public static void main(String[] args) {

        // sorted :   1, 2, 3, 4, 5, 6, 7, 8, 9
        int arr[] = { 2, 3, 1, 4, 6, 7, 5, 8, 9 };
        int k = 2;
        printSorted(arr, k);
    }
}
