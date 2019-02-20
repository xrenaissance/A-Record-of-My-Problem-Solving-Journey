public class Solution {
  public int[] quickSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }
  
  private void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    Random random = new Random();
    int randomIndex = random.nextInt(right - left + 1) + left;
    swap(array, randomIndex, right);
    int i = left, j = right - 1;
    while (i <= j) {
      if (array[i] < array[right]) {
        i++; 
      } else {
        swap(array, i, j);
        j--;
      }
    }
    swap(array, i, right);
    quickSort(array, left, i - 1);
    quickSort(array, i + 1, right);
  }
  
  private void swap(int[] array, int x, int y) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }
}
