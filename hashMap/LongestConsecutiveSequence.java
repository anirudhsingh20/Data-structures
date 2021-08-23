package hashMap;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    static void printLongestConsecutiveSequence(int arr[]) {

        HashMap<Integer, Boolean> hm = new HashMap<>();

        // iterate over array one and mark each element as start of sequence (1st step)
        for (int e : arr) {
            hm.put(e, true);
        }

        /*
         * iterate over array and find all start of sequence check whether element
         * previous value exsists or not if exsist then it is not starting of the
         * sequence
         */
        for (int e : arr) {
            if (hm.containsKey(e - 1)) {
                hm.put(e, false);
            }
        }

        // calculate sequence count;
        int maxSeqStart = 0;
        int maxSeqEnd = 0;
        
        for (int e : arr) {
            if (hm.get(e)) {
                int val = e;
                int seqCount = 1;

                while (hm.containsKey(val + seqCount)) {
                    seqCount++;
                }

                if (seqCount > maxSeqEnd - maxSeqStart) {
                    maxSeqStart = e;
                    maxSeqEnd = e + seqCount - 1;
                }
            }
        }

        for (int i = maxSeqStart; i <= maxSeqEnd; i++) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {

        int arr[] = { 10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 };
        printLongestConsecutiveSequence(arr);
    }
}
