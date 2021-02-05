package dynamicprogramming;

public class CountStairPathMemoization {
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countStairPathMemoization(n, new int[  n + 1]));
    }

    private static int countStairPathMemoization(int n, int[] qb) {

        if(n == 0 )
            return 1;
        else if (n < 0)
            return 0;
        
        int path1 = countStairPathMemoization(n-1, qb);
        int path2 = countStairPathMemoization(n-2, qb);
        int path3 = countStairPathMemoization(n-3, qb);

        int paths = path1 + path2 + path3;

        qb[n] = paths;
        return paths;
    }
}
