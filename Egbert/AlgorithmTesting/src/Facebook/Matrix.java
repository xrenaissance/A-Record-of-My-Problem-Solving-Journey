package Facebook;

/**
 * @leetcode https://leetcode.com/problems/01-matrix/
 * @Time m * n
 * @Space m * n
 */
public class Matrix {
    // dp[i][j] represent the distance of the nearest 0 for @i,j
    // dp[i][j] = 0 if matrix[i][j] = 0
    // dp[i][j] = min(dp[i+-1][j+-1]) + 1 if matrix[i][j] = 1
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int range = rows * cols;

        int[][] distances = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int up = i - 1 >= 0 ? distances[i - 1][j] : range;
                    int left = j - 1 >= 0 ? distances[i][j - 1] : range;
                    distances[i][j] = Math.min(up, left) + 1;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    int down = i + 1 < rows ? distances[i + 1][j] : range;
                    int right = j + 1 < cols ? distances[i][j + 1] : range;
                    distances[i][j] = Math.min(Math.min(down, right) + 1, distances[i][j]);
                }
            }
        }
        return matrix;
    }
}
