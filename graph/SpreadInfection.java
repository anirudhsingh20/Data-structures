package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class SpreadInfection {
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
        int v;
        int time;

        Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // INPUT:
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
        int time = Integer.parseInt(sc.nextLine());
        sc.close();

        // logic

        int count = 0;
        int isVisited[] = new int[vertices];

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src, 1));

        while (queue.size() > 0) {
            Pair p = queue.removeFirst();

            if(isVisited[p.v] > 0){
                continue;
            }
            isVisited[p.v] = p.time;
            
            if(p.time > time){
                break;
            }

            count++;

            for(Edge e: graph[p.v]){
                if(isVisited[e.neighbour] == 0){
                    queue.add(new Pair(e.neighbour, p.time + 1));
                }
            }
        }

        System.out.println(count + " people affected by infection");

    }
}
