package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class IsCycleByBFS {

    static class Edge {
        int v;
        int nbr;

        Edge(int v, int nbr) {
            this.v = v;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    static boolean isCycle(ArrayList<Edge>[] graph, int src, boolean[] isVisited) {
        // Logic
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0) {
            Pair p = queue.removeFirst();

            if (isVisited[p.v]) {
                return true;
            }
            isVisited[p.v] = true;

            // System.out.println(p.v + "@" + p.psf);

            for (Edge e : graph[p.v]) {
                if (!isVisited[e.nbr]) {
                    queue.add(new Pair(e.nbr, p.psf + e.nbr));
                }
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // INPUT:
        // 7
        // 8
        // 0 1
        // 1 2
        // 2 3
        // 0 3
        // 3 4
        // 4 5
        // 5 6
        // 4 6

        // OUTPUT
        // There is a cycle in graph

        // INPUT:
        // 7
        // 6
        // 0 1 10
        // 1 2 10
        // 2 3 10
        // 3 4 10
        // 4 5 10
        // 5 6 10

        // OUTPUT
        // There is no cycle in the graph

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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        int src = 0;
        sc.close();
        
        boolean[] isVisited = new boolean[vertices];
        
        System.out.println(isCycle(graph, src, isVisited) ? "There is a cycle in the graph" : "There is no cycle in the graph");

    }
}
