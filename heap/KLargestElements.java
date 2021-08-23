package heap;
import java.util.PriorityQueue;

public class KLargestElements {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 56, 11, 6, 7, 69, 100 };

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = 3;

        for(int i = 0 ; i < arr.length ; i++){
            if(i < k){  
                pq.add(arr[i]);
            }
            else{
                if(arr[i] > pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while(pq.size() > 0){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}
