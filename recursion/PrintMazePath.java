package recursion;

public class PrintMazePath {
    
    public static void main(String[] args) {
        
        printMazePath(1,1,3,3,"");
    }

    private static void printMazePath(int sr, int sc, int dr, int dc, String ans) {

        if(dc == sc && dr == sr) {
            System.out.print(ans + " ");
            return;
        }

        //vertical moves
        if(sr< dr) {
            printMazePath(sr + 1, sc, dr, dc, ans + 'v');
        }

        // horizontal moves
        if(sc < dc){
            printMazePath(sr, sc + 1, dr, dc, ans + 'h');
        }

    }
}
