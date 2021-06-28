package LinkedList;

public class MergeTwoSortedLinkedList {

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
                System.out.print(tempHead.data + " ");
                tempHead = tempHead.next;
            }
            System.out.println();
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

        void addAtIndex(int idx, int val) {
            Node temp = new Node();
            temp.data = val;

            if (idx < 0 || idx > size) {
                System.out.println("invalid index");
                return;
            }
            // first/last and empty
            else if (size == 0 && idx == 0) {
                head = tail = temp;
            }
            // first
            else if (idx == 0 && size > 0) {
                addFirst(val);
            }
            // last
            else if (idx == size) {
                addLast(val);
            } else {
                Node tempNode = head;
                for (int i = 0; i < idx; i++) {
                    tempNode = tempNode.next;
                }
                temp.next = tempNode.next;
                tempNode.next = temp;
                size++;
            }
        }

        void removeLast() {
            if (size == 0) {
                System.out.println("List is empty, cannot remove an element");
                return;
            } else if (size == 1) {
                tail = head = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;
                size--;
            }
        }
    }

    public static LinkedList mergeTwoSortedList(LinkedList l1, LinkedList l2){
        LinkedList mergedList = new LinkedList();

        Node s1 = l1.head;
        Node s2 = l2.head;

        while(s1 != null || s2 != null){

            if(s1 == null && s2 != null){
                mergedList.addLast(s2.data);
                s2 = s2.next;
            }
            else if(s2 == null && s1 != null){
                mergedList.addLast(s1.data);
                s1 = s1.next;
            }
            else if(s1.data <= s2.data){
                mergedList.addLast(s1.data);
                s1 = s1.next;
            }
            else {
                mergedList.addLast(s2.data);
                s2 = s2.next;
            }
        }

        return mergedList;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        ll1.addLast(5);
        ll1.addLast(15);
        ll1.addLast(25);
        ll1.addLast(35);
        ll1.addLast(45);
        ll1.addLast(55);
        ll1.addLast(65);
        ll1.display();


        ll2.addLast(10);
        ll2.addLast(20);
        ll2.addLast(30);
        ll2.addLast(40);
        ll2.addLast(50);
        ll2.addLast(60);
        ll2.display();

        LinkedList mergedList = mergeTwoSortedList(ll1,ll2);

        mergedList.display();

    }
}
