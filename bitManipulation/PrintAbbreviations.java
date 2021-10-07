package bitManipulation;
import java.util.*;

public class PrintAbbreviations {
    public static void solve(String str){
        // write your code here
        int n = (1 << str.length());
        
        for(int i = 0 ; i < n ; i++){
            String ans = "";
            int count = 0;
            for(int j = 0 ; j < str.length(); j++){
                char ch = str.charAt(j);
                int bit = str.length() - 1 - j; 
                int mask = 1 << bit;
                
                if((mask & i) == 0){
                    if(count > 0){
                        ans += count;
                        count = 0;
                    }
                    ans += ch;
                }
                else{
                    count++;
                }
            }
            if(count > 0){
                ans += count;
            }
            System.out.println(ans);
        }
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        
        solve(str);
    }
}
