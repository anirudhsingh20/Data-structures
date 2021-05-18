package stack;
import java.util.Stack;

public class GreaterElementToRight2 {
    //left to right traversal based approach

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};

        int nge[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for(int i = 1; i< arr.length; i++){
            while(st.size() > 0 && arr[i]>= arr[st.peek()]){
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        //update value of the elements who dont have any greater element to the right
        while(st.size() > 0 ){
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }

        for(int e : nge)
            System.out.print(e + ",");
    }
}
