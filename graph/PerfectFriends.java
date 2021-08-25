package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectFriends {

    static class Edge {
        int v;
        int n; // neighbour

        Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }

    static void getAllConnectedComponents(ArrayList<Edge>[] graph, int start, boolean[] isVisited,
            ArrayList<Integer> comp) {
        isVisited[start] = true;
        comp.add(start);

        for (Edge e : graph[start]) {
            if (!isVisited[e.n]) {
                getAllConnectedComponents(graph, e.n, isVisited, comp);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Sample Input
        // 7
        // 5
        // 0 1
        // 2 3
        // 4 5
        // 5 6
        // 4 6
        // Sample Output
        // 16

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int j = 0; j < k; j++) {
            String[] parts = sc.nextLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        sc.close();

        boolean isVisited[] = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                getAllConnectedComponents(graph, i, isVisited, comp);
                comps.add(comp);
            }
        }

        int pairs = 0;

        // to calculate no. of ways pair can be formed
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }
        }

        System.out.println(pairs);
    }

}
