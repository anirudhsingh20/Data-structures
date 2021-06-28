package LinkedList;

// 2 constraints:
//   size() must not be used directly or indirectly
//   iterative approach mush be used

public class GetMiddleElementOfLinkedList {

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

        int getMiddleElement(){
            if(size == 0){
                return -1;
            }
            else {
                Node s = head;
                Node f = head;

                while (f.next != null && f.next.next != null){
                    s = s.next;
                    f = f.next.next;
                }

                return s.data;
            }
        }


    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addLast(60);
        ll.addLast(70);
        ll.display();

        System.out.println("middle element of the linked list: " + ll.getMiddleElement());
    }
}
