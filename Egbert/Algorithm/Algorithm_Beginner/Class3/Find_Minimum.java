public class Solution {
  public int min(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }
}
