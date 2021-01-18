package searching;

public class MaximumSumSuchThatNoTwoAdjacentElementTogether {

    public static int findSum(int arr[]) {

        if (arr.length == 0) return -1;

        int incl_sum = arr[0];  // store sum including prev value
        int excl_sum = 0;       // store sum excluding prev value

        int new_excl;   // to find max of last incl_sum and excl_sum

        // loop start from 1
        for(int i = 1;i < arr.length; i++) {

            new_excl  = incl_sum > excl_sum ? incl_sum : excl_sum;

            incl_sum = excl_sum + arr[i];
            excl_sum = new_excl;
        }

        return incl_sum > excl_sum ? incl_sum : excl_sum;

    }
    
    public static void main (String args[]) {

        int arr[] = {5,  5, 10, 40, 50, 35};

        System.out.println(findSum(arr));

    }
}
