package recursion;

public class Fibonacci {
    
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    static int fib(int n) {
        if(n == 1 || n == 0)
            return n;

        return fib(n-1) + fib(n-2);
    }
}
