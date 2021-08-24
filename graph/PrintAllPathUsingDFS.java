package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllPathUsingDFS {
    static class Edge {
        int src;
        int neighbour; // destination
        int weight;

        Edge(int src, int neighbour, int weight) {
            this.src = src;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    static class Path {
        ArrayList<Integer> path;
        boolean hasPath;

        Path() {
            path = new ArrayList<>();
        }
    }

    public static void findAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] isVisited, String path) {
        if (src == dest) {
            System.out.println(path);
        }

        isVisited[src] = true;
        for (Edge edge : graph[src]) {

            if (!isVisited[edge.neighbour]) {
                findAllPaths(graph, edge.neighbour, dest, isVisited, path + edge.neighbour);
            }
        }
        isVisited[src] = false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // INPUT no. 1:
        // 7 (vertices)
        // 8 (edges)
        // 0 1 10
        // 1 2 10
        // 2 3 10
        // 0 3 10
        // 3 4 10
        // 4 5 10
        // 5 6 10
        // 4 6 10
        // 0 (source)
        // 6 (dest.)


        Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < edges; i++) {
            String parts[] = sc.nextLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(sc.nextLine());
        int dest = Integer.parseInt(sc.nextLine());
        boolean[] isVisited = new boolean[vertices];
        
        System.out.println("All Paths:");
        String path = "";
        findAllPaths(graph, src, dest, isVisited, path + src);
        sc.close();
    }
}
