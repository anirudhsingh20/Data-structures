package recursion;

public class LinearPower {
    public static void main(String[] args) {
        System.out.println(power(3,3));
    }
    public static int power(int x, int n) {  // x^n
        
        if(n==0) return 1;
        return x*power(x,n-1);
    }
}
