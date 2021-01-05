package strings;

public class DuplicateInString {
    
    public static void main(String args[]) {

        String s = "Hello world ";

        int left =0 , right = s.length() -1;

        int[] duplicates = new int[256];

        while(left < right) {

            duplicates[(int)s.charAt(left++)]++;
            duplicates[(int)s.charAt(right--)]++;

        }
        int index = 0;
        for(int e : duplicates )
         {
             if(e>1) {
                 System.out.println((char)index + ", count = " + e );
                }
                index++;
         }

    }
}
