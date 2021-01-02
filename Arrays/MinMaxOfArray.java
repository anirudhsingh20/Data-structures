package arrays;
public class MinMaxOfArray {
    public static void main(String Args[]) {

        // array a[]
        int[] a = {1,2,4,5,6,7,8,9,100,1213,11221, -1, 0}; 
        int min, max, i;

        if(a.length == 1){
            min = a[0];
            max = a[0];
        }
        else{
            // initialize min and max variables

            // for even min and max initial value is selected from a[0] and a[1]
            if(a.length %2 == 0) {
                if(a[0]>a[1]){
                    min = a[1];
                    max = a[0];
                }
                else{
                    min = a[0];
                    max = a[1];
                }
                i =2;
            }
            // for odd min and max initial value will be a[0]
            else{
                min = a[0];
                max = a[1];
                i=1;
            }

            // logic for min max checking
            while(i < a.length - 1) {
                if(a[i+1] > a[i] )
                {
                    if(a[i+1] > max) {
                        max = a[i+1];
                    }
                    if(a[i] < min) {
                        min = a[i];
                    }
                }
                else {
                    if(a[i] > max) {
                        max = a[i];
                    }
                    if(a[i+1] < min) {
                        min = a[i+1];
                    }
                }
                i+=2;   // increment 2 times
            }
            

        }
        System.out.println("Min value is : " + min);
        System.out.println("Max value is : " + max);

    }
}
