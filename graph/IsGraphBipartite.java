package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IsGraphBipartite {
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

    static class Pair {
        String psf;
        int level;
        int vertex;

        Pair(int vertex, String psf, int level) {
            this.vertex = vertex;
            this.psf = psf;
            this.level = level;
        }
    }

    static boolean isComponentBipartite(ArrayList<Edge>[] graph, int src, int[] isVisited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "", 0));

        while (queue.size() > 0) {
            Pair p = queue.removeFirst();

            if (isVisited[p.vertex] != -1) {
                if (p.level != isVisited[p.vertex]) {
                    return false;
                }

            } else {
                isVisited[p.vertex] = p.level;
            }

            for (Edge e : graph[p.vertex]) {
                if (isVisited[e.neighbour] == -1) {
                    queue.add(new Pair(e.neighbour, p.psf + e.neighbour, p.level + 1));
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // INPUT 1:
        // 2
        // 1
        // 0 1 1

        // OUTPUT
        // true

        // INPUT 2:
        // 7
        // 8
        // 0 1 10
        // 1 2 10
        // 2 3 10
        // 0 3 10
        // 3 4 10
        // 4 5 10
        // 5 6 10
        // 4 6 10

        // OUTPUT
        // false

        // INPUT 3:
        // 7
        // 6
        // 0 1 10
        // 1 2 10
        // 2 3 10
        // 3 4 10
        // 4 5 10
        // 5 6 10

        // OUTPUT
        // true

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
        sc.close();

        int[] isVisited = new int[vertices];
        Arrays.fill(isVisited, -1);

        for (int i = 0; i < vertices; i++) {
            if (isVisited[i] == -1) {
                if (!isComponentBipartite(graph, i, isVisited)) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}
