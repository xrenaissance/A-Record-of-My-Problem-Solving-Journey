package DP;

/**
 * @author Egbert Li
 * @date 3/5/2019
 * Time: O (n ^ 3)
 * Space: O(m x n)
 */
public class LargestSubMatrixSum {
    // M[i] represents largest sum for adjacent submatrix
    // base case: matrix has only one row, so find the largest sum
    // matrix has two rows: add two rows together, formed a combined matrix, and it
    // continuous, and it's using same rule find max sum, records global max sum
    // matrix has 3 rows: max sum exists in row1, row2, row3, row 1 and row 2, row1,row2 and row3
    // so it's becoming very clear, simply iterate the row from top to bottom
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int largest = Integer.MIN_VALUE;
        int N = matrix.length;
        int M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            int[] curr = new int[M];
            for (int j = i; j < N; j++) {
                add(curr, matrix[j]);
                largest = Math.max(largest, maxSum(curr));
            }
        }
        return largest;
    }
    private void add(int[] curr, int[] currRow) {
        for (int i = 0; i < currRow.length; i++) {
            curr[i] += currRow[i];
        }
    }
    private int maxSum(int[] combinedSubMatrix) {
        int max = combinedSubMatrix[0];
        int curr = combinedSubMatrix[0];
        for (int i = 1; i < combinedSubMatrix.length; i++) {
            curr = Math.max(combinedSubMatrix[i], combinedSubMatrix[i] + curr);
            max = Math.max(curr, max);
        }
        return max;
    }
}
