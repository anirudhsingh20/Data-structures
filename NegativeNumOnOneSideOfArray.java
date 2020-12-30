//Ques. Move all negative numbers to beginning and positive to end with constant extra space

public class NegativeNumOnOneSideOfArray {
    
    public static void main(String args[]) {

        int[] array = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        int i=0, j=0, n = array.length;

        // j will be the index position of positive element that we have to swap with a negative element.


        while(i < n-1 && j < n ) {

            if(array[i]>=0){

                if(array[i+1] <0){
                    //swap
                    array[j] = array[j] +array[i+1];
                    array[i+1] = array[j] - array[i+1];
                    array[j] = array[j] - array[i+1];
                    i++;j++;
                }
                else {
                    i++;
                }

            }
            else {
                i++;
                j++;
            }
        }

        for(int e:array) 
            System.out.println(e);
    }
}
