public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (array.length == 0 || k == 0) {
      return new int[0]; 
    }
    quickSort(array, k - 1, 0, array.length - 1);
    int[] result = Arrays.copyOf(array, k);
    //for (int i = 0; i < k; i++) {
    //  result[i] = array[i];
    //}
    Arrays.sort(result);
    return result;
  }
  
  private void quickSort(int[] array, int k, int left, int right) {
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
    if (k == start) {
      return; 
    } else if (k < start) {
      quickSort(array, k, left, start - 1);
    } else {
      quickSort(array, k, start + 1, right);
    }
  }
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
