package UnionFind;

public class UnionFind {
    int[] father;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = -i;
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
