package LinkedList;

class AddTwoLinkedLists {

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

    public static int addTwoLinkedListsHelper(Node one, int placeValueOfOne, Node two, int placeValueOfTwo,
            LinkedList res) {
        if (one == null && two == null) {
            return 0;
        }

        int data = 0;
        if (placeValueOfOne > placeValueOfTwo) {
            int carry = addTwoLinkedListsHelper(one.next, placeValueOfOne - 1, two, placeValueOfTwo, res);
            data = one.data + carry;

        } else if (placeValueOfTwo > placeValueOfOne) {
            int carry = addTwoLinkedListsHelper(one, placeValueOfOne, two.next, placeValueOfTwo - 1, res);
            data = one.data + carry;
        } else {
            int carry = addTwoLinkedListsHelper(one.next, placeValueOfOne - 1, two.next, placeValueOfTwo - 1, res);
            data = one.data + two.data + carry;
        }

        int newData = data % 10;
        int newCarry = data / 10;

        res.addFirst(newData);

        return newCarry;
    }

    public static LinkedList addTwoLinkedLists(LinkedList one, LinkedList two) {
        LinkedList res = new LinkedList();

        int carry = addTwoLinkedListsHelper(one.head, one.size(), two.head, two.size(), res);

        if (carry > 0) {
            res.addFirst(carry);
        }

        return res;
    }

    public static void main(String[] args) {

        LinkedList one = new LinkedList();
        one.addLast(9);
        one.addLast(9);
        one.addLast(9);

        LinkedList two = new LinkedList();
        two.addLast(6);
        two.addLast(5);
        two.addLast(5);

        LinkedList res = addTwoLinkedLists(one, two);

        System.out.println("First List");
        one.display();

        System.out.println("Second List");
        two.display();

        System.out.println("Sum of the two List");
        res.display();  // final result
    }
}