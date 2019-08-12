package UnionFind;
/**
 * @leetcode https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 * @Time NlogN + N
 * @Space N for sorting
 */
import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int n, int[][] connections) {
        if (connections == null) {
            return -1;
        }
        // nlogn
        Arrays.sort(connections, (c1, c2) -> {
            int priority = c1[2] - c2[2];
            if (priority == 0) {
                priority = c1[0] - c2[0];
            }
            if (priority == 0) {
                priority = c1[1] - c2[1];
            }
            return priority;
        });
        UnionFind uf = new UnionFind(n * 2);
        int total = 0;
        int numEdges = 0;
        // N
        for (int[] edge : connections) {
            int c1 = edge[0];
            int c2 = edge[1];
            int cost = edge[2];
            if (uf.find(c1) != uf.find(c2)) {
                total += cost;
                numEdges++;
                uf.union(c1, c2);
            }
        }
        if (numEdges == n - 1) {
            return total;
        } else {
            return -1;
        }
    }
    public class UnionFind {
        int[] father;
        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = -1;
            }
        }
        // O 1
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a < b) {
                father[a] += father[b];
                father[b] = a;
            } else {
                father[b] += father[a];
                father[a] = b;
            }
        }
        // amortized O 1
        public int find(int x) {
            if (father[x] < 0) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
    }
}
