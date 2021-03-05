package recursion;

class TowerOfHanoi {
    public static void main(String[] args) {
        toh(4, 'A', 'B', 'C');
    }

    public static void toh(int n, char tower1, char tower2, char tower3) { // move disc n (let say 3) from tower 1
        if (n == 0)
            return;

        toh(n - 1, tower1, tower3, tower2); // recursion
        System.out.println("move " + n + "[ " + tower1 + " -> " + tower2 + " ]");
        toh(n - 1, tower3, tower2, tower1); // recursion
    }
}