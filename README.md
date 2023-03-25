# Data-structures

Data Structure questions using java programming Language.

---

# Sorting

## Bubble Sort

> It is the simplest sorting algorithm that works by repeateadly swapping adjacent elements if they are not in correct order

This algo is not suitable for larger data set as it avg and worst cast time complexit is `O(n)`

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