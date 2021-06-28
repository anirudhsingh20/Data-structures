package LinkedList;

public class MergeSortLinkedList {

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

    public static LinkedList mergeTwoSortedList(LinkedList l1, LinkedList l2) {
        LinkedList mergedList = new LinkedList();

        Node s1 = l1.head;
        Node s2 = l2.head;

        while (s1 != null || s2 != null) {

            if (s1 == null && s2 != null) {
                mergedList.addLast(s2.data);
                s2 = s2.next;
            } else if (s2 == null && s1 != null) {
                mergedList.addLast(s1.data);
                s1 = s1.next;
            } else if (s1.data <= s2.data) {
                mergedList.addLast(s1.data);
                s1 = s1.next;
            } else {
                mergedList.addLast(s2.data);
                s2 = s2.next;
            }
        }

        return mergedList;
    }

    public static Node findMid(Node head, Node tail) {

        Node s = head;
        Node f = tail;

        while (f != tail && f.next != tail) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public static LinkedList mergeSort(Node head, Node tail) {

        if (head == tail) {
            LinkedList temp = new LinkedList();
            temp.addLast(head.data);
            return temp; // return list with single element
        }

        Node mid = findMid(head, tail);
        LinkedList fsh = mergeSort(head, mid); // first half
        LinkedList Ssh = mergeSort(mid.next, tail); // second half
        LinkedList sortedList = mergeTwoSortedList(fsh, Ssh); // merge the list
        return sortedList;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(65);
        ll.addLast(55);
        ll.addLast(45);
        ll.addLast(35);
        ll.addLast(25);
        ll.addLast(15);
        ll.addLast(5);

        System.out.println("Unsorted List:");
        ll.display();

        LinkedList sortedList = mergeSort(ll.head, ll.tail);

        System.out.println("Sorted List:");
        sortedList.display();

    }
}
