package DP;

/**
 * @author Egbert Li
 * @date 3/5/2019
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        if (source == null || target == null) {
            return 0;
        }
        int rows = source.length();
        int cols = target.length();
        int[][] matrix = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    if (i == 1 || j == 1) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        return matrix[rows][cols];
    }
}
