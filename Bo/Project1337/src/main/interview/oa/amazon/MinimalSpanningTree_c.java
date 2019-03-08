package main.interview.oa.amazon;

import java.util.ArrayList;
import java.util.Collections;

public class MinimalSpanningTree_c {

    private static int[] parent;

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 4, 0));
        edges.add(new Edge(4, 5, 0));
        edges.add(new Edge(2, 3, 0));

        edges.add(new Edge(1, 6, 2));
        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(5, 6, 5));
        edges.add(new Edge(1, 3, 10));

        Collections.sort(edges);

        parent = new int[edges.size() + 1];
        for (int i = 0; i <= edges.size(); i++) {
            parent[i] = i;
        }

        int sum = 0;
        for (Edge edge : edges) {
            int start = find(edge.src);
            int end = find(edge.dest);
            if (start != end) {
                parent[start] = end;
                sum += edge.weight;
            }
            System.out.println("new road!");
        }

        System.out.println(parent);

        System.out.println(sum);
    }

    private static int find(int k) {
        if (k != parent[k]) {
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }

    private static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
