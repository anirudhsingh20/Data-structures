package strings;

public class temp {

    public static void main(String args[]) {

        int arr[] = {1,2,3,2,1};  // arr

        boolean isPlaindrom = true; 

        int left = 0, right = arr.length -1;
            // 4  > 2 
        for(      ;left <= right;      ) {   ///   

            if(arr[left++] != arr[right--]) {  // O(n/2)  -->  O(n)
                isPlaindrom = false;
                break;
            }

        }

        System.out.println(isPlaindrom ? true: false);
    }
}