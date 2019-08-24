package TopologicalSort;

/**
 * @leetcode https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * @Time m * n
 * @Space m * n
 *
 * @key since previous node, we have already visited, we just
 * need to cache before current node, how many nodes are smaller
 * than current node, so we use dfs to get the max length so far
 * then simply need a global max to output the max length
 */
public class LongestIncreasingPathInAMatrix {
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int longest = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int length = dfs(matrix, i, j, cache);
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
    private int dfs(int[][] matrix, int currRow,
                    int currCol, int[][] cache) {
        if (cache[currRow][currCol] != 0) {
            return cache[currRow][currCol];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int neiRow = currRow + dx[i];
            int neiCol = currCol + dy[i];
            if (isValid(neiRow, neiCol, rows, cols) &&
                    matrix[neiRow][neiCol] < matrix[currRow][currCol]) {
                int length = 1 + dfs(matrix, neiRow, neiCol, cache);
                max = Math.max(max, length);
            }
        }
        cache[currRow][currCol] = max;
        return max;
    }
    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows &&
                col >= 0 && col < cols;
    }
}
