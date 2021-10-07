package bitManipulation;
import java.util.*;

public class ValidUTF8 {
    public static boolean solution(int[] arr) {
        //write your code here
        int rBytes = 0;
        
        for(int val : arr){
            if(rBytes == 0){
                if((val >> 7) == 0b0){
                    rBytes = 0;
                }
                else if((val >> 5) == 0b110){
                    rBytes = 1;
                }
                else if((val >> 4) == 0b1110){
                    rBytes = 2;
                }
                else if((val >> 3) == 0b11110){
                    rBytes = 3;
                }
            }
            else{
                if((val >> 6) == 0b10){
                    rBytes--;
                }
                else {
                    return false;
                }
            }
        }
        
        if(rBytes > 0){
            return false;
        }
        else{
            return true;
        }
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        
        System.out.println(solution(arr));
    }
}
