package UnionFind;

public class NumberOfLandsTest {
    public static void main(String[] args) {
        NumberOfLandsTest nol = new NumberOfLandsTest();
        char[][] input = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        nol.numIslands(input);
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int total = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    total++;
                }
            }
        }
        UnionFind uf = new UnionFind(rows * cols);
        uf.setCount(total);
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                                grid[nx][ny] == '1') {
                            uf.union(i * cols + j, nx * cols + ny);
                        }
                    }
                }
            }
        }
        return uf.query();
    }
    public class UnionFind {
        int[] father;
        int count;
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
            this.count--;
        }
        public int find(int x) {
            if (father[x] < 0) {
                return x;
            }
            System.out.println(father[x]);
            father[x] = find(father[x]);
            return father[x];
        }
        public void setCount(int total) {
            this.count = total;
        }
        public int query() {
            return this.count;
        }
    }
}
