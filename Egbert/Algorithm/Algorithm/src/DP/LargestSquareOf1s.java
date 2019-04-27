package DP;

/**
 * @author Egbert Li
 * @date 28/04/2019
 * matrix[i][j] means largest square of 1s with right
 * bottom corner as matrix[i][j]
 * Time: O(n * n)
 * Space: O(1)
 */
public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }
        int largest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] > 0) {
                        largest = Math.max(largest, matrix[i][j]);
                    }
                    continue;
                } else if (matrix[i][j] > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]);
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j - 1]) + 1;
                    largest = Math.max(largest, matrix[i][j]);
                }

            }
        }
        return largest;
    }
}
