package recursion;

class TowerOfHanoi {
    public static void main(String[] args) {
        toh(5, 10, 11, 12);
    }

    public static void toh(int n, int tower1, int tower2, int tower3) { // move disc n (let say 3) from tower 1
        if (n == 0)
            return;

        toh(n - 1, tower1, tower3, tower2); // recursion
        System.out.println(n + "[ " + tower1 + " -> " + tower2 + " ]");
        toh(n - 1, tower3, tower2, tower1); // recursion
    }
}