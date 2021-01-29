package recursion;

class LogarithmicPower{
    public static void main(String[] args) {
        System.out.println(power(3,3));
    }

    public static int power(int x, int n) {

        if(n == 0) return 1;

        return n%2==0 ? power(x,n/2) * power(x,n/2) : power(x, n/2) * power(x,n/2) * x;
        
    }
}