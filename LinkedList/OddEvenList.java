package LinkedList;

public class OddEvenList {

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

        void removeDuplicates() {
            LinkedList result = new LinkedList();
            while (this.size > 0) {
                int val = this.getFirst();
                this.removeFirst();

                if (result.size == 0 || result.tail.data != val) {
                    result.addLast(val);
                }
            }
            this.head = result.head;
            this.tail = result.tail;
            this.size = result.size;
        } 
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(65);
        ll.addLast(65);
        ll.addLast(65);
        ll.addLast(55);
        ll.addLast(45);
        ll.addLast(45);
        ll.addLast(35);
        ll.addLast(25);
        ll.addLast(25);
        ll.addLast(25);
        ll.addLast(25);
        ll.addLast(25);
        ll.addLast(15);
        ll.addLast(5);

        System.out.println("List with duplicates:");
        ll.display();

        ll.removeDuplicates();

        ll.display();
    }
}
