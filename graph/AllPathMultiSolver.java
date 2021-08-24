package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AllPathMultiSolver {
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

    static int k = 0;
    static PriorityQueue<Pair> pq;
    static String lowestPath;
    static int lowestPathWeight = Integer.MAX_VALUE;
    static String largestPath;
    static int largestPathWeight = Integer.MIN_VALUE;
    static String ceilPath;
    static int ceilPathWeight = Integer.MAX_VALUE;
    static String floorPath;
    static int floorPathWeight = Integer.MIN_VALUE;

    static class Path {
        ArrayList<Integer> path;
        boolean hasPath;

        Path() {
            path = new ArrayList<>();
        }
    }

    static class Pair implements Comparable<Pair> {
        int weight;
        String path;

        public Pair(int weight, String path) {
            this.weight = weight;
            this.path = path;
        }

        public int compareTo(Pair o) {
            return weight - o.weight;
        }

    }

    public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, int criteria, boolean[] isVisited,
            String pathSoFar, int weightSoFar) {
        if (src == dest) {

            // largest
            if (weightSoFar > largestPathWeight) {
                largestPathWeight = weightSoFar;
                largestPath = pathSoFar;
            }

            // smallers
            if (weightSoFar < lowestPathWeight) {
                lowestPathWeight = weightSoFar;
                lowestPath = pathSoFar;
            }

            // for ceil
            if (weightSoFar > criteria && weightSoFar < ceilPathWeight) {
                ceilPathWeight = weightSoFar;
                ceilPath = pathSoFar;
            }

            // for floor
            if (weightSoFar < criteria && weightSoFar > floorPathWeight) {
                floorPathWeight = weightSoFar;
                floorPath = pathSoFar;
            }

            // kth largest
            if (pq.size() < k) {
                pq.add(new Pair(weightSoFar, pathSoFar));
            } else {
                if (pq.peek().weight < weightSoFar) {
                    pq.remove();
                    pq.add(new Pair(weightSoFar, pathSoFar));
                }
            }

            return;
        }

        isVisited[src] = true;
        for (Edge edge : graph[src]) {

            if (!isVisited[edge.neighbour]) {
                multiSolver(graph, edge.neighbour, dest, criteria, isVisited, pathSoFar + edge.neighbour,
                        weightSoFar + edge.weight);
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
        // 30 (criteria for ceil and floor)
        // 4 (k for kth largest)

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

        int criteria = Integer.parseInt(sc.nextLine());
        k = Integer.parseInt(sc.nextLine());
        boolean[] isVisited = new boolean[vertices];

        String path = "";
        int weight = 0;
        pq = new PriorityQueue<>();
        multiSolver(graph, src, dest, criteria, isVisited, path + src, weight);

        System.out.println("lowest path: " + lowestPath + "@" + lowestPathWeight);
        System.out.println("largest path: " + largestPath + "@" + largestPathWeight);
        System.out.println("ceil path for " + criteria + " : " + ceilPath + "@" + ceilPathWeight);
        System.out.println("floor path for " + criteria + ": " + floorPath + "@" + floorPathWeight);
        System.out.println("kth (k=" + k + ") largest path: " + pq.peek().path + "@" + pq.peek().weight);

        sc.close();
    }
}
