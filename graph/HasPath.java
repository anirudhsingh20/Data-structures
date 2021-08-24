package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class HasPath {
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

    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] isVisited) {
        if (src == dest) {
            return true;
        }
        if (!isVisited[src]) {
            isVisited[src] = true;
            for (Edge vertice : graph[src]) {
                if (hasPath(graph, vertice.neighbour, dest, isVisited)) {
                    return true;
                }
            }
        }

        return false;
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

        // INPUT no. 2:
        // 7
        // 7
        // 0 1 10
        // 1 2 10
        // 2 3 10
        // 0 3 10
        // 4 5 10
        // 5 6 10
        // 4 6 10
        // 0
        // 6

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
        System.out.println(hasPath(graph, src, dest, isVisited));
        sc.close();
    }
}
