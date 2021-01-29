package recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
    public static int factorial(int a) {
        if(a==0) return 1;
        return a*factorial(a-1);
    }
}
