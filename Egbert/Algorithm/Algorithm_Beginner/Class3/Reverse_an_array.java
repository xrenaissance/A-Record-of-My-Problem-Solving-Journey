public class Solution {
  
  public void swap(int[] array, int x, int y) {
   int temp = array[x];
   array[x] = array[y];
   array[y] = temp;
  }
  public void reverse(int[] array) {
    for (int i = 0, j = array.length - 1; j > i; i++,j--) {
       swap(array, i, j);
    }
  }
}
