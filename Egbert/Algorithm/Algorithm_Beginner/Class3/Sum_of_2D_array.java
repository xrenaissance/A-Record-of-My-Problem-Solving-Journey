public class Solution {
  public int sum(int[][] array) {
    int sum = 0;
    int row = array.length;
    int col = array[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
       sum += array[i][j]; 
      }
    }
    return sum;
  }
}
