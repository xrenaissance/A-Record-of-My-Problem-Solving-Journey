package KWayMerge;

import java.util.PriorityQueue;

/**
 * @date 20/7/2019
 * @leetcode https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @Time k log k
 * @Space n ^ 2 + k
 */
public class KthSmallestInSortedMatrix {
    public static int findKthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(matrix[e1.row][e1.col], matrix[e2.row][e2.col])
        );
        minHeap.offer(new Cell(0, 0));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        while (k > 0 && !minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            k--;
            if (k == 0) {
                return matrix[cell.row][cell.col];
            }
            if (isValid(matrix, cell.row + 1, cell.col) &&
                    !visited[cell.row + 1][cell.col]) {
                minHeap.offer(new Cell(cell.row + 1, cell.col));
                visited[cell.row + 1][cell.col] = true;
            }
            if (isValid(matrix, cell.row, cell.col + 1) &&
                    !visited[cell.row][cell.col + 1]) {
                minHeap.offer(new Cell(cell.row, cell.col + 1));
                visited[cell.row][cell.col + 1] = true;
            }
        }
        return -1;
    }
    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row< matrix.length &&
                col >= 0 && col < matrix[0].length;
    }
    public static class Cell {
        public int row;
        public int col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
