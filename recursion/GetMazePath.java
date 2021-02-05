package recursion;

import java.util.ArrayList;

public class GetMazePath {
    
    public static void main(String[] args) {
        
        System.out.println(getMazePath(1, 1, 3, 3));
    }

    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) { // source row and column ; destination row and col
                   
        if(sr == dr && sc == dc ) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        ArrayList<String> hPaths = new ArrayList<>();
        ArrayList<String> vPaths = new ArrayList<>();

        ArrayList<String> paths = new ArrayList<>();

        if(sr < dr) {
            vPaths = getMazePath(sr+1, sc, dr, dc);
        }
        if(sc < dc) {
            hPaths = getMazePath(sr, sc + 1, dr, dc);
        }

        for (String string : hPaths) {
             paths.add('h' + string);
        }
        
        for (String string : vPaths) {
            paths.add('v' + string);
        }

        return paths;
    }
}
