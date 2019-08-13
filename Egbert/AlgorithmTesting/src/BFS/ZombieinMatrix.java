package BFS;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @leetcode https://www.lintcode.com/problem/zombie-in-matrix/description?_from=ladder&&fromId=14
 * @Time m * n
 * @Space 4 ^ (m)
 */
public class ZombieinMatrix {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        // get water points
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }
        int dist = 0; // number of layers
        // starting level order hurt people
        while (!qx.isEmpty()) {
            int size = qx.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int cx = qx.poll();
                int cy = qy.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                            grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        qx.offer(nx);
                        qy.offer(ny);
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return dist - 1;
    }
}
