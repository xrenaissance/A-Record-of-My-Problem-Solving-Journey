package Facebook;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/diagonal-traverse/
 * @Time m * n
 * @Space m * n
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9}
        };
        DiagonalTraverse d = new DiagonalTraverse();
        d.findDiagonalOrder(matrix);
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        Deque<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[] result = new int[rows * cols];
        boolean leftToRight = true;
        queue.offerLast(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        int index = 0;
        Cell currCell = null;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    currCell = queue.pollFirst();
                    int currRow = currCell.row;
                    int currCol = currCell.col;
                    int neiRow = currRow + 1;
                    int neiCol = currCol + 1;

                    if (neiRow < rows && !visited[neiRow][currCol]) {
                        queue.offerLast(new Cell(neiRow, currCol, matrix[neiRow][currCol]));
                        visited[neiRow][currCol] = true;
                    }

                    if (neiCol < cols && !visited[currRow][neiCol]) {
                        queue.offerLast(new Cell(currRow, neiCol, matrix[currRow][neiCol]));
                        visited[currRow][neiCol] = true;
                    }

                } else {
                    currCell = queue.pollLast();
                    int currRow = currCell.row;
                    int currCol = currCell.col;
                    int neiRow = currRow + 1;
                    int neiCol = currCol + 1;

                    if (neiCol < cols && !visited[currRow][neiCol]) {
                        queue.offerFirst(new Cell(currRow, neiCol, matrix[currRow][neiCol]));
                        visited[currRow][neiCol] = true;
                    }

                    if (neiRow < rows && !visited[neiRow][currCol]) {
                        queue.offerFirst(new Cell(neiRow, currCol, matrix[neiRow][currCol]));
                        visited[neiRow][currCol] = true;
                    }
                }
                result[index++] = currCell.value;
            }

            leftToRight = !leftToRight;
        }

        return result;
    }

    public static class Cell {
        int row;
        int col;
        int value;
        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
