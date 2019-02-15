public class Solution {
  public void swap(int[] array, int x, int y) {
   int temp = array[x];
   array[x] = array[y];
   array[y] = temp; 
  }
  public int[] solve(int[] array) {
    if (array == null || array.length == 0) {
      return array; 
    }

    for (int i = 0; i < array.length; i++) {
       int min = array[i];
       int minIndex = i;
       for (int j = i + 1; j < array.length; j++) {
         if (array[j] < min) {
           min = array[j];
           minIndex = j;
         }
       }
      swap(array, i, minIndex);
    }
    return array;
  }
}
