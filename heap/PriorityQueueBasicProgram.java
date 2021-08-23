package heap;
// import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueBasicProgram {
    
    public static void main(String[] args) {
            
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // // To reverse priority order
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ranks[] = { 12,15,1,2,4,10,5,6,7,34,434,23,28};

        for(int e: ranks){
            pq.add(e);
        }

        while(pq.size() > 0){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}
