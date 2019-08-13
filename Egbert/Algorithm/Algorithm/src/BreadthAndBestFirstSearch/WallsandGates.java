package BreadthAndBestFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode https://leetcode.com/problems/walls-and-gates/
 * @Time M * N
 * @Space worst m * n
 */
public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        int rows = rooms.length;
        int cols = rooms[0].length;
        // get all water points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }
        // bfs search
        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < rows && ny >=0 && ny < cols &&
                        rooms[nx][ny] == Integer.MAX_VALUE) {
                    rooms[nx][ny] = rooms[cx][cy] + 1;
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
    }
}
