package main.onlinejudges.codeforces.solutions.closed.monash;

import java.util.ArrayList;

/**
 * Shenlu Wang's FoldFulkerson DFS implementation
 * Fails at something like test #45 due to limitation of DFS algorithm
 */
public class _MonashD_SW {
    private ArrayList<Edge> edges;
    private ArrayList<Integer>[] adj;
    private int source;
    private int sink;
    private int n;
    private boolean[] visited;

    @SuppressWarnings("unchecked")
    public _MonashD_SW(int n, int s, int t) {
        source = s;
        sink = t;
        this.n = n;
        edges = new ArrayList<Edge>();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
    }

    public void addEdge(int u, int v, int c) {
        Edge e1 = new Edge(v, c, 0);
        adj[u].add(edges.size());
        edges.add(e1);
        Edge e2 = new Edge(u, 0, 0);
        adj[v].add(edges.size());
        edges.add(e2);
    }

    private int findflow(int u, int min) {
        if (u == sink)
            return min;
        visited[u] = true;
        for (int ei : adj[u]) {
            int v = edges.get(ei).v;
            if (!visited[v] && edges.get(ei).c - edges.get(ei).f > 0) {
                int f = findflow(v,
                        Math.min(min, edges.get(ei).c - edges.get(ei).f));
                if (f > 0) {
                    edges.get(ei).f += f;
                    edges.get(ei ^ 1).f -= f;
                    return f;
                }
            }
        }
        return 0;
    }

    public int maxflow() {
        int total = 0, f = 1;
        while (f > 0) {
            visited = new boolean[n];
            f = findflow(source, Integer.MAX_VALUE);
            total += f;
        }
        return total;
    }

    protected class Edge {
        int v, c, f;

        public Edge(int v, int c, int f) {
            super();
            this.v = v;
            this.c = c;
            this.f = f;
        }
    }
}

