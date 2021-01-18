package strings;

public class temp {

    public static void main(String args[]) {

        int arr[] = { -1, 2, 0 , -8, 5};  // arr

        int j = 0;

        for(int i=0; i<arr.length -1; i++) {

            if(arr[i]<0) {
                // perform something 
                // building mei defect hai
                j++;

            }
            else{
                // something else       // [ -1, 2, 0 , -8, 5]
                if(arr[i+1] < 0){
                    // do something
                    //swap
                    int temp = arr[i+1];
                    arr[i+1]= arr[j];
                    arr[j]= temp;

                    j++;
                }

            }
        }

        for(int e : arr){
            System.out.println(e);
        }
    }
}