# Data-structures

Data Structure questions using java programming Language.

---

# Sorting

<pre>
1. Bubble sort    [simple]
2. Insertion sort [simple]
3. Selection sort [simple]

4. Merge sort     [divide & conquer]
5. Quick sort     [divide & conquer]

6. Counting sort

7. Radix sort   [extra]
8. Shell sort   [extra]
</pre>

### Stablility of sorting algoritms

A Sorting algo is said to be stable if 2 objects with equal keys appear in same order in sorted outpust as appear in input array to be sorted

ex.... 10, 20, 20*, 30, 10
output 10, 10, 20, 20*, 30 // here 20* appear in same place after and before sorting w.r.t 20

Stable algo: bubble insertion, merge, count
Unstable algo: quick, heap sort selection sort

Note: Any given algo which is not stable can be made stable

## Bubble Sort

> It is the simplest sorting algorithm that works by repeateadly swapping adjacent elements if they are not in correct order

This algo is not suitable for larger data set as it avg and worst cast time complexit is `O(n^2)`

```
public static void bubble_sort(int[] arr) {

   for (int i = 0; i <= arr.length / 2; i++) {
      for (int j = i + 1; j < arr.length; j++) {
         if (arr[i] > arr[j]) { // swapping
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
      }
   }

   for (int i : arr) {
      System.out.println(i);
   }
}
```

<img src="./images/bubble.jpg" width="500"/>

Optimization
: If inner loop don't swap just break the outer loop.

```
   public static void bubble_sort(int[] arr) {
      boolean swapped = false;
      for (int i = 0; i <= arr.length / 2; i++) {
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               swapped = true;
            }
         }
         if (!swapped) {
            break; // break if array is already sorted
         }
      }
   }
```

> **best case** time complexity would be `O(n)`, worst and avg case still `O(n^2)`
