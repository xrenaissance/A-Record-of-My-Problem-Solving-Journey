public class Solution {
  public int findElement(int[][] matrix, int k) {
    if (matrix == null) {
      return -1; 
    }
    int row = matrix.length;
    int col = matrix[0].length;
    return matrix[k / col][k % col];
  }
}
