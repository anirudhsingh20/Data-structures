package LinkedList;

public class AddFirstInLinkedList {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        int size() {
            return size;
        }

        void display() {
            Node tempHead = head;
            while (tempHead != null) {
                System.out.println(tempHead.data);
                tempHead = tempHead.next;
            }
        }

        void removeFirst() {
            if (size == 0)
                return;
            else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
            // garbage collector job
            // // Node tempHead = head;
            // // tempHead = head.next;
            // // head = null;
            // // head = tempHead;
        }

        int getFirst() {
            if (size <= 0) {
                return -1;
            }
            return head.data;
        }

        int getLast() {
            if (size <= 0) {
                return -1;
            }
            return tail.data;
        }

        int getAtIndex(int idx) {
            if (size <= 0) {
                System.out.println("List is empty");
                return -1;
            } else if (size <= idx || idx < 0) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                int index = 0;
                Node tempNode = head;
                while (index < idx) {
                    tempNode = tempNode.next;
                    index++;
                }

                return tempNode.data;
            }
        }

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            } 

            size++;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.removeFirst();
        ll.removeFirst();
        ll.addFirst(5);
        ll.addFirst(51);
        // System.out.println("Value at index 1: " + ll.getAtIndex(3));

        ll.display();
        System.out.println("size of linked list: " + ll.size());

    }
}
