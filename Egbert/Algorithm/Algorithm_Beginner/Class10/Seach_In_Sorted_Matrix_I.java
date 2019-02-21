public class Solution {
  public int[] search(int[][] matrix, int target) {
    int[] result = new int[]{-1, -1};
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    
    int row = matrix.length, col = matrix[0].length;
    int left = 0, right = row * col - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      int currRow = mid / col, currCol = mid % col;
      if (target == matrix[currRow][currCol]) {
        result[0] = currRow;
        result[1] = currCol;
        return result;
      } else if (target > matrix[currRow][currCol]) {
        left = mid;
      } else {
        right = mid; 
      }
    }

    if (target == matrix[left / col][left % col]) {
      result[0] = left / col;
      result[1] = left % col;
    } else if (target == matrix[right / col][right % col]) {
      result[0] = right / col;
      result[1] = right % col;
    } 
    return result;
  }
}
