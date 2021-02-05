package recursion;

import java.util.ArrayList;

public class GetMazePathWithJumps {
    public static void main(String[] args) {
        System.out.println(getMazePathWithJumps(1, 1, 3, 3));
    }

    public static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        //result ArrayList
        ArrayList<String> paths = new ArrayList<>();

        // horizontal moves
        for(int ms = 1 ; ms <= dc - sc; ms++) // ms -> move size
        {
            ArrayList<String> hPaths = getMazePathWithJumps(sr, sc + 1, dr, dc);
            for (String hPath : hPaths) {
                paths.add("v" + ms + hPath);
            }
        }
        
        // vertical moves
        for(int ms = 1 ; ms <= dr - sr; ms++) // ms -> move size
        {
            ArrayList<String> vPaths = getMazePathWithJumps(sr + 1, sc, dr, dc);
            for (String vPath : vPaths) {
                paths.add("d" + ms + vPath);
            }
        }
        // diagnol moves
        for(int ms = 1 ; ms <= dc - sc && ms <= dr - sr ; ms++) // ms -> move size
        {
            ArrayList<String> dPaths = getMazePathWithJumps(sr + 1, sc + 1, dr, dc);
            for (String dPath : dPaths) {
                paths.add("h" + ms + dPath);
            }
        }    
        
        return paths;
    }
}
