package recursion;

public class PrintMazePathWithJumps {
    
    public static void main(String[] args) {
        printMazePathWithJumps(1,1,3,3,"");
    }

    private static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String ans) {

        // base condition
        if(dr == sr && dc == sc) {
            System.out.print(ans + " ");
        }

        // vertical moves 
        for(int ms = 1 ; ms <= dr - sr ; ms++) {
            printMazePathWithJumps(sr + ms, sc, dr, dc, ans + 'v' + ms);
        }

        // horizontal moves 
        for(int ms = 1 ; ms <= dc - sc ; ms++) {
            printMazePathWithJumps(sr, sc + ms, dr, dc, ans + 'h' + ms);
        }

        // diagnol moves 
        for(int ms = 1 ; ms <= dr - sr && ms <= dc - sc ; ms++) {
            printMazePathWithJumps(sr + ms, sc + ms, dr, dc, ans + 'd' + ms);
        }
    }
}
