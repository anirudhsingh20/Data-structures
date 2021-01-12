package searching;

public class FirstAndLastOccurenceInAnUnsortedArray {

    public static void search(int arr[], int x) {

        int first_occurence = -1, last_occurence = -1;
    
        for(int i= 0 ; i < arr.length ; i++ ) {
            if(arr[i]== x) {
                if(first_occurence == -1) 
                        first_occurence = i;
                last_occurence = i;
            }
        }
        System.out.println(first_occurence + " " + last_occurence);
    }
    public static void main (String args[]) {

        int arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        search(arr, x);

    }
}