package BreadthAndBestFirstSearch;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcdoe https://leetcode.com/problems/surrounded-regions/
 * @Time 3 * m * n
 * @Space m * n
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            bfs(board, i, 0);
            bfs(board,i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            bfs(board, 0, i);
            bfs(board, rows - 1, i);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void bfs(char[][] board, int dx, int dy) {
        if (board[dx][dy] == 'X') {
            return;
        }
        int[] move1 = new int[]{0, 0, -1, 1};
        int[] move2 = new int[]{-1, 1, 0, 0};
        Queue<Integer> xaxis = new LinkedList<>();
        Queue<Integer> yaxis = new LinkedList<>();
        xaxis.offer(dx);
        yaxis.offer(dy);
        board[dx][dy] = 'W';
        while (!xaxis.isEmpty()) {
            dx = xaxis.poll();
            dy = yaxis.poll();
            for (int i = 0; i < 4; i++) {
                int neiX = dx + move1[i];
                int neiY = dy + move2[i];
                if (neiX >= 0 && neiX < board.length && neiY >= 0 &&
                        neiY < board[0].length && board[neiX][neiY] == 'O') {
                    board[neiX][neiY] = 'W';
                    xaxis.offer(neiX);
                    yaxis.offer(neiY);
                }
            }
        }
    }
}
