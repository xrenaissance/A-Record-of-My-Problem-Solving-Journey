package Facebook;
import java.util.Map;
import java.util.HashMap;
/**
 * @leetcode https://leetcode.com/problems/toeplitz-matrix/
 * @Time M * N
 * @Space 1
 */
public class ToeplitzMatrix {
   // follow-ups
   public boolean isToeplitzMatrix(int[][] matrix) {
       if (matrix == null || matrix.length == 0) {
           return true;
       }

       int rows = matrix.length;
       int cols = matrix[0].length;
       Map<Integer, Integer> diagMapping = new HashMap<>();

       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < cols; j++) {
               if (!diagMapping.containsKey(i - j)) {
                   diagMapping.put(i - j, matrix[i][j]);
               } else {
                   if (matrix[i][j] != diagMapping.get(i - j)) {
                       return false;
                   }
               }
           }
       }

       return true;
   }

    // clean code
    public boolean isToeplitzMatrixClean(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    // My initial solution
    // Time m * n
    // Space 1
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // bottom left
        for (int i = 0; i < rows; i++) {
            if (!evalDiag(matrix, i, 0)) {
                return false;
            }
        }

        for (int i = 1; i < cols; i++) {
            if (!evalDiag(matrix, 0, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean evalDiag(int[][] matrix, int row, int col) {
        int nextRow = row + 1;
        int nextCol = col + 1;
        if (nextRow < matrix.length && nextCol < matrix[0].length) {
            if (matrix[row][col] != matrix[nextRow][nextCol]) {
                return false;
            } else {
                return evalDiag(matrix, row + 1, col + 1);
            }
        }

        return true;
    }
}
