package heap;

import java.util.*;

public class PriorityQueueUsingHeap {

    public static class PriorityQueue {
        static ArrayList<Integer> list;

        PriorityQueue() {
            list = new ArrayList<>();
        }

        int peek(){
            if(size() <= 0 ){
                System.out.println("Underflow");
                return -1;
            }

            return list.get(0);
        }

        void add(int val){
            list.add(val);
            upheapify(list.size() -1);
        }

        private void upheapify(int i){
            if(i == 0){
                return;
            }
            int pi = (i - 1) / 2; // i is child index here;
            if(list.get(i) < list.get(pi)){
                swap(i,pi);
            }
        }

        private void downheapify(int i){
            //i here is parent index
            int mini = i;

            int lci = 2*i+1; // left child index;
            if(lci < list.size() && list.get(mini) > list.get(lci) ){
                mini = lci;
            }

            int rci = 2*i+2; // right child index;
            if(rci < list.size() && list.get(mini) > list.get(rci)){
                mini = rci;
            }

            if(mini != i){
                swap(mini, i);
                downheapify(mini);
            }

        }

        private void swap(int i , int j){
            int ith= list.get(i);
            int jth= list.get(j);
            list.set(i, jth);
            list.set(j, ith);
        }

        int remove(){
            if(this.size() <= 0){
                System.out.println("Underflow");
                return -1;
            }
            swap(0, list.size() -1);
            int val = list.remove(size() -1);
            downheapify(0);
            return val;
        }
        int size(){
            return list.size();
        }
    }

    public static void main(String[] args) {
        int arr[] = {11,22,43,46,58,68,87,98,19};

        PriorityQueue pq = new PriorityQueue();

        for(int e : arr){
            pq.add(e);
        }

        System.out.println("Size: " + pq.size());

        while(pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
