public class Solution {
  public int minIndex(int[] array, int i) {
    int min = array[i];
    int minIndex = i;
    for (; i < array.length; i++) {
     if (array[i] < min) {
       min = array[i];
       minIndex = i;
     }
    }
    return minIndex;
  }
}
