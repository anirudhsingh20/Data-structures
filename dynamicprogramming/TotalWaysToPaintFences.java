package dynamicprogramming;

public class TotalWaysToPaintFences {
    
    public static void main(String[] args) {

        int n = 5;  // no. of fences
        int k = 3;  // no. of colors
        totalWays(n,k);  // such that not more than 2 fences have the same color
    }

    private static void totalWays(int n, int k) {

        int same = k * 1;  // same 2 colors at the end
        int diff = k * (k-1); // no 2 same colors at the end
        int total = same + diff; // total ways

        for ( int i = 3 ; i <= n ; i++) {

            same = diff * 1;
            diff = total * (k-1);
            total = same + diff;

        }

        System.out.println(total);
    }
}
