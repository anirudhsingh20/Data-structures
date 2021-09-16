package recursionAndBacktracking2;

public class PairFriends2 {

    static int counter;
    static void solve(int i, int n, boolean used[], String asf) {

        if (i > n) {
            System.out.println(counter + "." + asf);
            counter++;
            return;
        }

        if (used[i] == true) {
            solve(i + 1, n, used, asf);
        } else {
            used[i] = true;
            solve(i + 1, n, used, asf + "(" + i + ") ");
            for (int j = i + 1; j <= n; j++) {
                if (used[j] == false) {
                    used[j] = true;
                    solve(i, n, used, asf + "(" + i + "," + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        boolean used[] = new boolean[n + 1];
        counter = 1;
        solve(1, n, used, "");
    }
}
