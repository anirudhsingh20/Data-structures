package hashMap;

import java.util.HashMap;

public class GetCommonElementFrom2Arrays {

    static void printCommonElements(int arr1[], int arr2[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // creates frequency map for array 1
        for (int e : arr1) {
            if (hm.containsKey(e)) {
                hm.put(e, hm.get(e) + 1);
            } else {
                hm.put(e, 1);
            }
        }

        // iterate over arr2 elements and compare values from frequency map of array 1
        for (int e : arr2) {
            if (hm.containsKey(e) && hm.get(e) > 0) {
                System.out.print(e + " ");
                hm.put(e, hm.get(e) + 1);
            }
            else{
                //do nothing
            }
        }
    }

    public static void main(String[] args) {

        int arr1[] = {1,1,1,2,2,2,3,3,5,7};
        int arr2[] = {1,1,2,2,3,3,5,8};

        printCommonElements(arr1, arr2);
    }
}
