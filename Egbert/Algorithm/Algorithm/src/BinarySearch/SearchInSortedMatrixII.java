package BinarySearch;

/**
 * @author Egbert Li
 * @Date 18/03/2019
 * Time Complexity O(m + n), Space Complexity O(m + n)
 */
public class SearchInSortedMatrixII {
    public int[] search(int[][] matrix, int target) {
        int[] result = new int[]{-1, -1};
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length, col = matrix[0].length;
        int rowIndex = 0, colIndex = col - 1;
        while (rowIndex <= row - 1 && colIndex >= 0) {
            if (target == matrix[rowIndex][colIndex]) {
                result[0] = rowIndex;
                result[1] = colIndex;
                return result;
            } else if (target > matrix[rowIndex][colIndex]) {
                rowIndex++;
            } else {
                colIndex--;
            }
        }
        return result;
    }
}
