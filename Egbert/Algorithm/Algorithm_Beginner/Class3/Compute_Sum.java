public class Solution {
  public int sum(int[] array) {
    if (array == null || array.length == 0) {
     return 0; 
    }
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }
}
