package dynamicprogramming;

public class fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibMemoized( n , new int[ n + 1 ] ));
    }

    static int fibMemoized(int n, int[] qb) // question bank
    {
        if(n == 0 || n == 1)
            return n;
        if(qb[n] != 0)
            return qb[n];

        int fib1 = fibMemoized(n-1, qb);
        int fib2 = fibMemoized(n-2, qb);
        int fib = fib1 + fib2;

        qb[n] = fib;
        return fib;
    }
}
