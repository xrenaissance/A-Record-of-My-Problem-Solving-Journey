package UnionFind;

/**
 * @leetcode https://leetcode.com/problems/number-of-islands/
 * @Time m * n
 * @Space m * n
 */
public class NumberofIslands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int total = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        UnionFind unionFind = new UnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]) {
                    total++;
                }
            }
        }
        unionFind.setCount(total);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                                grid[nx][ny]) {
                            unionFind.union(i * cols + j, nx * cols + ny);
                        }
                    }
                }
            }
        }
        return unionFind.query();
    }
    public class UnionFind {
        int[] father;
        int count;
        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                father[a] = b;
                count--;
            }
        }
        public int find(int x) {
            if (father[x] == x) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }
        public int query() {
            return count;
        }
        public void setCount(int total) {
            count = total;
        }
    }
}
