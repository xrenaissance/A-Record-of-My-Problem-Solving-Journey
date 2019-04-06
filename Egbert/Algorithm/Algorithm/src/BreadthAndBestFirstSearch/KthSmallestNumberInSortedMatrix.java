package BreadthAndBestFirstSearch;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * @author Egbert Li
 * @date 7/4/2019
 * Time complexity: 2 * O( k log k) + lok k  --->3 * O ( k log k)
 * Space complexity : O(2 * k) at most
 */
public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        PriorityQueue<Cell> minHeap =
                new PriorityQueue<Cell>(new Comparator<Cell>() {
                    public int compare(Cell c1, Cell c2) {
                        if (c1.value == c2.value) {
                            return 0;
                        }
                        return c1.value < c2.value ? -1 : 1;
                    }
                });
        int rows = matrix.length;
        int cols = matrix[0].length;
        // record visited or not
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i ++) {
            Cell currMin = minHeap.poll();
            if (currMin.row + 1 < rows && !visited[currMin.row + 1][currMin.col]) {
                minHeap.offer(new Cell(currMin.row + 1, currMin.col, matrix[currMin.row + 1][currMin.col]));
                visited[currMin.row + 1][currMin.col] = true;
            }
            if (currMin.col + 1 < cols && !visited[currMin.row][currMin.col + 1]) {
                minHeap.offer(new Cell(currMin.row, currMin.col + 1, matrix[currMin.row][currMin.col + 1]));
                visited[currMin.row][currMin.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }
    static class Cell {
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
