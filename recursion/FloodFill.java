package recursion;
import java.util.Scanner;

public class FloodFill {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int maze[][]= new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0 ; j < c ; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        boolean IsVisited[][] = new boolean[r][c];

        floodFill(maze, 0, 0,"",IsVisited);
        sc.close();

    }

    private static void floodFill(int[][] maze, int row, int col, String path, boolean[][] isVisited) {
    
        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || isVisited[row][col] == true){
            return;
        }
        if(row == maze.length -1 && col == maze[0].length -1)
        {
            System.out.println(path);
            return;
        }

        isVisited[row][col] = true;
        // LEFT paths
        floodFill(maze, row, col-1, path + "L", isVisited);
        
        // BOTTOM paths
        floodFill(maze, row+1, col, path + "B", isVisited);
        
        // RIGHT paths
        floodFill(maze, row, col+1, path + "R", isVisited);
        
        // TOP paths
        floodFill(maze, row-1, col, path + "L", isVisited);
        
        isVisited[row][col] = false;

    }
}
