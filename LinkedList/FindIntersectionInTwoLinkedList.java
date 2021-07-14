package LinkedList;

public class FindIntersectionInTwoLinkedList {

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

 
    public static int findIntersection(LinkedList one, LinkedList two) {

        Node n1 = one.head;
        Node n2 = two.head;

        int delta = Math.abs(one.size - two.size);

        if(delta > 0){
            if(one.size > two.size){
                for(int i = 0; i< delta ; i++){
                    n1 = n1.next;
                }
            }
            else{
                for(int i = 0; i< delta ; i++){
                    n2 = n2.next;
                }
            }
        }

        while(n1.data != n2.data){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1.data;
    }

    public static void main(String[] args) {

        LinkedList one = new LinkedList();
        one.addLast(1);
        one.addLast(6);
        one.addLast(1);
        one.addLast(3);
        one.addLast(5);

        LinkedList two = new LinkedList();
        two.addLast(9);
        two.addLast(3);
        two.addLast(5);

        int res = findIntersection(one, two);

        System.out.println("First List");
        one.display();

        System.out.println("Second List");
        two.display();

        System.out.println("Intersection of List :" + res); // final result
    }
}