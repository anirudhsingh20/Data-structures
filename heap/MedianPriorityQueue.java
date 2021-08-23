package heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianPriorityQueue {

    static class CustomPriorityQueue {
        static PriorityQueue<Integer> left;
        static PriorityQueue<Integer> right;

        CustomPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();

        }

        void add(int val) {
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            // diffrence between no. of elment in left and right priority queue must be less
            // than 2
            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        int remove() {
            if (size() == 0) {
                System.out.println("underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        int size() {
            return left.size() + right.size();
        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 4, 6, 7, 5, 8, 9, 10, 11 };

        CustomPriorityQueue pq = new CustomPriorityQueue();

        for (int e : arr) {
            pq.add(e);
        }

        System.out.println(pq.peek());
    }
}