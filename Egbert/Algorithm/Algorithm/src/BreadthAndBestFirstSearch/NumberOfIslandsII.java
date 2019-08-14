package BreadthAndBestFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @leetcode https://leetcode.com/problems/number-of-islands-ii/
 * @Time 4D D = positions.length
 * @Space D + m*n D=positions.length if grid is counted
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }
        int[][] grid = new int[m][n];
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        UnionFind uf = new UnionFind(m * n);
        Set<Integer> visited = new HashSet<>();
        // D times D = positions.length
        for (int i = 0; i < positions.length; i++) {
            int cx = positions[i][0];
            int cy = positions[i][1];
            grid[cx][cy] = 1;
            // O 1
            if (!visited.contains(cx * n + cy)) {
                uf.setCount(uf.count + 1);
                visited.add(cx * n + cy);
            }
            // O 4
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    uf.union(cx * n + cy, nx * n + ny); // O 1
                }
            }
            result.add(uf.query());
        }
        return result;
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
                this.count--;
            }
        }
        public int find(int x) {
            if (father[x] == x) {
                return x;
            }
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
