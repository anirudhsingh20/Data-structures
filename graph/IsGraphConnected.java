package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class IsGraphConnected {

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

    static void getAllConnectedComponents(ArrayList<Edge>[] graph, int src, boolean[] isVisited,
            ArrayList<Integer> comp) {

        isVisited[src] = true;
        comp.add(src);

        for (Edge e : graph[src]) {
            if (!isVisited[e.neighbour]) {
                getAllConnectedComponents(graph, e.neighbour, isVisited, comp);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // INPUT no. 1:
        // 7
        // 5
        // 0 1 10
        // 2 3 10
        // 4 5 10
        // 5 6 10
        // 4 6 10

        // OUTPUT: false

        // INPUT no .:
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

        // OUTPUT: true

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
        boolean[] isVisited = new boolean[vertices];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                getAllConnectedComponents(graph, i, isVisited, comp);
                comps.add(comp);
            }
        }

        System.out.println(comps.size() == 1);
        sc.close();
    }
}
