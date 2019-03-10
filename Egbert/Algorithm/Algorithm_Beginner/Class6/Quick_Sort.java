public class Solution {
  public int[] quickSort(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }
  
  private void quickSort(int[] array, int left, int right) {
    if (left >= right) return;
    Random random = new Random();
    int randomIndex = random.nextInt(right - left + 1) + left;
    swap(array, randomIndex, right);
    int start = left, end = right - 1;
    while (start <= end) {
      if (array[start] <= array[right]) {
        start++; 
      } else {
        swap(array, start, end);
        end--;
      }
    }
    swap(array, start, right);
    quickSort(array, left, start - 1);
    quickSort(array, start + 1, right);
  }
  
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
