package bitManipulation;

import java.util.Scanner;

public class AllRepeatingExceptTwo {
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
          arr[i] = scn.nextInt();
        }
        scn.close();
        solution(arr);
      }
    
      public static void solution(int[] arr){
       //write your code here
       int xxory =0;
       
       for(int e: arr){
           xxory ^= e;
       }
        
        int rsbm = xxory & -xxory;
        
        int x = 0, y = 0;
        
        for(int e: arr){
            if((e & rsbm) == 0)
                x ^= e;
            else 
                y ^= e;
        }
        
        if(x < y){
            System.out.println(x);
            System.out.println(y);
        }
        else {
            System.out.println(y);
            System.out.println(x);
            
        }
      }
}
