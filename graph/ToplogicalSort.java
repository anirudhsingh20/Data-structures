package graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ToplogicalSort {

    static class Edge {
        int v;
        int nbr;

        Edge(int v, int nbr) {
            this.v = v;
            this.nbr = nbr;
        }
    }

    static void sort(ArrayList<Edge>[] graph, int src, boolean[] isVisited, Stack<Integer> st){
        isVisited[src]= true;
        for(Edge e: graph[src]){
            if(!isVisited[e.nbr]){
                sort(graph, e.nbr, isVisited, st);
            }
        }
        st.push(src);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // INPUT:
        // 7
        // 7
        // 0 1
        // 1 2
        // 2 3
        // 0 3
        // 4 5
        // 5 6
        // 4 6

        // OUTPUT
        // TOPOLOGICAL SORT:
        // 4
        // 5
        // 6
        // 0
        // 1
        // 2
        // 3

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
        sc.close();

        // Logic
        boolean isVisited[] = new boolean[vertices];
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < vertices; i++){
            if(!isVisited[i]) {
                sort(graph, i, isVisited, st);
            }
        }

        System.out.println("TOPOLOGICAL SORT:");

        while(st.size() > 0){
            System.out.println(st.pop());
        }

    }
}
