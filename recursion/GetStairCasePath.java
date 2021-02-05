package recursion;

import java.util.ArrayList;

public class GetStairCasePath {
    
    public static void main(String[] args) {
        System.out.println(getStairCasePath(4));
    }

    public static ArrayList<String> getStairCasePath(int n){

        if(n == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        else if(n < 0) {
            return new ArrayList<>();  // empty arraylist;
        }

        ArrayList<String> path1 = getStairCasePath(n-1);
        ArrayList<String> path2 = getStairCasePath(n-2);
        ArrayList<String> path3 = getStairCasePath(n-3);

        ArrayList<String> paths = new ArrayList<>();

        for (String path : path1) {
            paths.add(1 + path);
        }
        for (String path : path2) {
            paths.add(2 + path);
        }
        for (String path : path3) {
            paths.add(3 + path);
        }

        return paths;
    }
}
