package searching;

public class LinearSearch {
    
    public static void main (String args[]) {

        int array[] = {5,4,4,6,5,1};
        int n = array.length;
        int e = 1;
        boolean isFound = false;

        //logic
        for(int i=0; i<n; i++) {
            if(array[i] == e){
                isFound=true;
                System.out.println("Element is at index : " + i);
                break;
            }
        }
        if(!isFound) {
            System.out.println("Element is not present in the array");
        }
    }
}
