package DP;

public class LargestXOf1s {
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] leftUp = leftUp(matrix, N, M);
        int[][] rightDown = rightDown(matrix, N, M);
        return merge(leftUp, rightDown, N, M);
    }

    // merger
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
    private int getNumber(int[][] number, int x, int y, int N, int M) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return 0;
        }
        return number[x][y];
    }
    private int[][] rightDown(int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];
        int[][] down = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getNumber(right, i + 1, j - 1, N, M) + 1;
                    down[i][j] = getNumber(down, i + 1, j + 1, N, M) + 1;
                }
            }
        }
        merge(right, down, N, M);
        return right;
    }

    private int[][] leftUp(int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = getNumber(left, i - 1, j - 1, N, M) + 1;
                    up[i][j] = getNumber(up, i - 1, j + 1, N, M) + 1;
                }
            }
        }
        merge(left, up, N, M);
        return left;
    }
}
