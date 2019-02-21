public class Solution {
  public int firstOccur(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0, right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (target == array[mid]) {
        right = mid; 
      } else if (target > array[mid]) {
        left = mid; 
      } else {
        right = mid; 
      }
    }
  
    if (array[left] == target) {
      return left; 
    } else if (array[right] == target) {
      return right; 
    } else {
      return -1; 
    }
  }
}
