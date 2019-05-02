package DP;

/**
 * @author Egbert Li
 * @date 3/05/2019
 * M[i][j] represents the longest length while source string is at ith position
 * and target string is at jth position
 * M[i][j] = M[i - 1][j - 1] + 1 if s[i] == t[j]
 * otherwise do nothing
 * M[i - 1][j - 1] the value of associated neighbor for both source and target
 * record global max and associated start point.
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class LongestCommonSubstring {
    public String longestCommonSol1(String source, String target) {
        if (source == null || target == null) {
            return "";
        }
        int rows = source.length();
        int cols = target.length();
        int[][] matrix = new int[rows][cols];
        int start = 0;
        int longest = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (source.charAt(i) == target.charAt(j)) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    if (matrix[i][j] > longest) {
                        longest = matrix[i][j];
                        start = i - longest + 1;
                    }
                }
            }
        }
        return source.substring(start, start + longest);
    }
    public String longestCommonSol2(String source, String target) {
        int m = source.length();
        int n = target.length();
        int[][] matrix = new int[m + 1][n + 1];
        int start = 0;
        int max = 0;
        for (int i = 1; i  <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                        start = i - max;
                    }
                }
            }
        }
        return source.substring(start, start + max);
    }
}
