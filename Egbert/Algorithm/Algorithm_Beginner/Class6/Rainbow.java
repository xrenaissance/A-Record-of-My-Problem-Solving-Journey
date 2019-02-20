public class Solution {
  public int[] rainbowSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int i = 0, j = 0, k = array.length - 1;
    while (j <= k) {
      if (array[j] == -1) {
        swap(array, i, j);
        i++;
        j++;
      } else if (array[j] == 0) {
        j++; 
      } else {
        swap(array, j, k);
        k--;
      }
    }
    return array;
  }
  private void swap(int[] array, int x, int y) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }
}
