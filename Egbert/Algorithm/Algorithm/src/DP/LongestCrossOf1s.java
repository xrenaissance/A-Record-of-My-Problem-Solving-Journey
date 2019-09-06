package DP;

/**
 * @author Egbert Li
 * @date 13/6/2019
 * Time: 3 n ^ 2
 * Space: O(2 n ^ 2)
 */
public class LongestCrossOf1s {
    // Assumption: matrix is not null, has size of N * M,
    // where N >= 0 and M >= 0
    public int largest(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }
        // leftup records the longest possible length for left and up
        // arms ending at each cells in the matrix
        int[][] leftUp = leftUp(matrix, N, M);
        // rightdown records the longest possible length for right and down
        // arms ending at each cells in the matrix
        int[][] rightDown = rightDown(matrix, N, M);
        // merge the two matrix by getting the min value for each cell,
        // and among all the cells get max value
        return merge(leftUp, rightDown, N, M);
    }

    // merge leftup and rightdown matrix into leftup,
    // the value of each cell is the min value of the corresponding cells
    // in the two matrix, also it returns the max value among all the cells
    // in the merged matrix
    private int merge(int[][] leftUp, int[][] rightDown, int N, int M) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    // calculate the max possible length of left and up arms
    // for each of the cells in the matrix
    private int[][] leftUp(int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1;
                    } else if (i == 0) {
                        up[i][j] = 1;
                        left[i][j] = left[i][j - 1] + 1;
                    } else if (j == 0) {
                        left[i][j] = 1;
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }
                }
            }
        }
        merge(left, up, N, M);
        return left;
    }

    // calculate the max possible length of right and up arms
    // for each of the cells in the matrix
    private int[][] rightDown(int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];;
        int[][] down = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == N - 1 && j == M - 1) {
                        right[i][j] = 1;
                        down[i][j] = 1;
                    } else if (j == M - 1) {
                        right[i][j] = 1;
                        down[i][j] = down[i + 1][j] + 1;
                        down[i][j] = down[i + 1][j] + 1;
                    } else if (i == N - 1) {
                        down[i][j] = 1;
                        right[i][j] = right[i][j + 1] + 1;
                    } else {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        merge(right, down, N, M);
        return right;
    }
}
