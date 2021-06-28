package LinkedList;

import java.util.LinkedList;

public class LinkedlistToQueueAdapter {
     public static class QueueAdapter {
        public LinkedList<Integer> list;

        QueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size();
        }

        void enqueue(int val) {
            list.addLast(val);
        }

        int dequeue() {
            if (size() == 0) {
                System.out.println("stack underflow");
                return -1;
            }
            return list.removeFirst();
        }

        int peek() {
            if (size() == 0) {
                System.out.println("stack underflow");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) {

        QueueAdapter queue = new QueueAdapter();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue());
        
        System.out.println(queue.peek());

    }
}
