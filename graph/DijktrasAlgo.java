package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijktrasAlgo {

    static class Edge {
        int v;
        int nbr;
        int wt;

        Edge(int v, int nbr, int wt) {
            this.v = v;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wt;

        Pair(int v, String psf, int wt) {
            this.v = v;
            this.psf = psf;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // INPUT:
        // 7
        // 9
        // 0 1 10
        // 1 2 10
        // 2 3 10
        // 0 3 40
        // 3 4 2
        // 4 5 3
        // 5 6 3
        // 4 6 8
        // 2 5 5
        // 0

        // OUTPUT:
        // 0 via 0 @ 0
        // 1 via 01 @ 10
        // 2 via 012 @ 20
        // 5 via 0125 @ 25
        // 4 via 01254 @ 28
        // 6 via 01256 @ 28
        // 3 via 012543 @ 30

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

        // Logic
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        boolean[] isVisited = new boolean[vertices];

        pq.add(new Pair(src, src + "", 0));

        while (pq.size() > 0) {
            Pair p = pq.remove();

            if (isVisited[p.v]) {
                continue;
            } else {
                isVisited[p.v] = true;
            }

            System.out.println(p.v + " via " + p.psf + " @ " + p.wt);

            for (Edge e : graph[p.v]) {
                if (!isVisited[e.nbr]) {
                    pq.add(new Pair(e.nbr, p.psf + e.nbr, p.wt + e.wt));
                }
            }
        }

    }
}
