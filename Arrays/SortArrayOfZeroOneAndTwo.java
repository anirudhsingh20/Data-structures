// Sort array on 1, 2 and 3 without using any sorting algorithm.

// also can be sloved using Dutch National Flag Algorithm OR 3-way Partitioning but this approach is better.
package arrays;

public class SortArrayOfZeroOneAndTwo {

    public static void sort012(int a[]){

        // count zero and one occurrences and increment them 
        int zero=0, one=0;
        for(int i =0; i < a.length;i++) {
            if(a[i] == 0) 
                zero++;
            else if (a[i] == 1) 
                one++;
        }

        for(int i =0; i<a.length; i++){
            if(zero >= i+1){
                a[i] = 0;
            }
            else if(zero + one >= i+1) {
                a[i]= 1;
            }
            else {
                a[i] = 2;
            }
        }
        System.out.println("Sorted Array : ");
        for(int e : a)
            System.out.print(e + " ");

    }
    public static void main(String args[]) {
        int[] arr =  { 0,1,2,0,2};

        // sort and print array
        sort012(arr);

    }
}