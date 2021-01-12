package searching;

// floor sqrt using binary search

public class SquareCount {
    
    static int floorSqrt(int x) {

        int l = 1 , h = x, ans = 0;

        if(x ==0 || x == 1)
            return 1;
        
        while(l<=h) {
            int m = l + (h-l)/2;

            if(m*m == x){
                return m;
            }
            else if( m*m < x){
                ans = m;
                l = m +1;
            }
            else 
                h = m -1;
        }
        return ans;
    }
    public static void main(String args[]) {

        int x = 49;
        System.out.println(floorSqrt(x));


    }
}
