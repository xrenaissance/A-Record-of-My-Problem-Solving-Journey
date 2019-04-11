package RecursionII;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Egbert Li
 * @date 11/4/2019
 * Time complexity: O(n * n)
 * Space complexity: O(n/2)
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        int size = matrix.length;
        spiral(matrix, 0, size, result);
        if (size % 2 == 1) {
            result.add(matrix[size / 2][size / 2]);
        }
        return result;
    }
    private void spiral(int[][] matrix, int offset,
                        int size, List<Integer>result) {
        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + 0][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + i][offset + size - 1]);
        }
        for (int i = size - 1; i > 0; i--) {
            result.add(matrix[offset + size - 1][offset + i]);
        }
        for (int i = size - 1; i > 0; i--) {
            result.add(matrix[offset + i][offset + 0]);
        }
        spiral(matrix, offset + 1, size - 2, result);
    }
}
