package BreadthAndBestFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @lintcode https://www.lintcode.com/problem/knight-shortest-path/description
 * @Time m * n
 * @Space m * n
 */
public class KnightShortestPath {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        if (grid[destination.x][destination.y]) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[source.x][source.y] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                for (int k = 0; k < 8; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                            !grid[nx][ny] && !visited[nx][ny]) {
                        if (nx == destination.x && ny == destination.y) {
                            return distance;
                        } else {
                            queue.offer(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
