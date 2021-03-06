package LinkedList;

public class DisplayLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        
        int size(){
            return size;
        }

        void display(){
            Node tempHead = head;
            while(tempHead != null){
                System.out.println(tempHead.data);
                tempHead = tempHead.next;
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

        ll.display();
        System.out.println("size of linked list: " + ll.size());


    }
}
