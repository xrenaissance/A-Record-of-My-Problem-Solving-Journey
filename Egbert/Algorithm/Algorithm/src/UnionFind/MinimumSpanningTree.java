package UnionFind;
import java.util.*;

public class MinimumSpanningTree {
    int n = 0;
    Map<String, Integer> name2ID = new HashMap<>();
    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> ans = new ArrayList<>();
        UnionFind unionFind = new UnionFind(connections.size() * 2);
        Collections.sort(connections, (c1, c2) -> {
            if (c1.cost != c2.cost) {
                return c1.cost - c2.cost;
            }
            if (c1.city1.equals(c2.city1)) {
                return c1.city2.compareTo(c2.city2);
            }
            return c1.city1.compareTo(c2.city1);
        });
        for (Connection item : connections) {
            int c1 = getID(item.city1);
            int c2 = getID(item.city2);
            if (unionFind.find(c1) != unionFind.find(c2)) {
                ans.add(item);
                unionFind.union(c1, c2);
            }
        }
        if (ans.size() == n - 1) {
            return ans;
        } else {
            return new ArrayList<>();
        }
    }
    public int getID(String name) {
        if (name2ID.containsKey(name)) {
            return name2ID.get(name);
        } else {
            name2ID.put(name, n++);
            return n - 1;
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
        public int find(int x) {
            if (father[x] < 0) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
    }
}
