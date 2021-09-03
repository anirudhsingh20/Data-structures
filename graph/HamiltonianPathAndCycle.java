package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HamiltonianPathAndCycle {
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

    static void printHamiltonianPathAndCylce(ArrayList<Edge>[] graph, int src, String psf, HashSet<Integer> set,
            int originalSrc) {

        if (set.size() == graph.length - 1) {
            System.out.print(psf);

            boolean isCycle = false;
            for (Edge e : graph[src]) {
                if (e.neighbour == originalSrc) {
                    isCycle = true;
                    break;
                }
            }

            if (isCycle) {
                System.out.println(" * cycle"); // cycle
            } else {
                System.out.println(" . path"); // path
            }
        }

        set.add(src);
        for (Edge e : graph[src]) {
            if (!set.contains(e.neighbour)) {
                printHamiltonianPathAndCylce(graph, e.neighbour, psf + e.neighbour, set, originalSrc);
            }
        }
        set.remove(src);

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // INPUT:
        // 7
        // 9
        // 0 1 10
        // 1 2 10
        // 2 3 10
        // 0 3 10
        // 3 4 10
        // 4 5 10
        // 5 6 10
        // 4 6 10
        // 2 5 10
        // 0

        // OUTPUT
        // 123456 . path
        // 123465 . path
        // 125643 * cycle
        // 346521 * cycle

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

        sc.close();

        // logic
        HashSet<Integer> set = new HashSet<>(); // similar to hashmap but contains only keys (constant time complexity
                                                // in best case and avg case)
        String path = "";

        printHamiltonianPathAndCylce(graph, src, path, set, src);
    }
}
