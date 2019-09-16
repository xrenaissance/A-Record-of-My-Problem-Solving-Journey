package Facebook;

public class FriendCircle {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int rows = M.length;
        boolean[] visited = new boolean[rows];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int other = 0; other < M.length; other++) {
            if (M[i][other] == 1 && !visited[other]) {
                visited[other] = true;
                dfs(M, visited, other);
            }
        }
    }


    // Solution 2: union find,maximum rows groups, if connect and different parent
    // count--, otherwise do nothing
    public int findCircleNumUnionFind(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int rows = M.length;
        int cols = M[0].length;
        UnionFind uf = new UnionFind(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.query();
    }

    public static class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int length) {
            parent = new int[length];
            this.count = length;

            for (int i = 0; i < length; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a != b) {
                parent[a] = b;
                count--;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return parent[x];
            }

            parent[x] = find(parent[x]);

            return parent[x];
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int query() {
            return this.count;
        }
    }
}
