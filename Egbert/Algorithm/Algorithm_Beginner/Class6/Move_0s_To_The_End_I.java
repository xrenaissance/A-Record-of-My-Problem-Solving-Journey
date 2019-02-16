public class Solution {
  public void swap(int[] array, int x, int y) {
     int temp = array[x];
     array[x] = array[y];
     array[y] = temp;
  }
  public int[] moveZero(int[] array) {
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      while (array[j] == 0 && j > 0) {
        j--;
      }
      if (array[i] == 0 && i < j) {
        swap(array, i, j);
      }
      i++;
    }
    return array;
  }
}
