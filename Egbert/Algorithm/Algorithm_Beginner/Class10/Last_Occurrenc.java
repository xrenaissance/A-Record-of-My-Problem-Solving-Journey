public class Solution {
  public int lastOccur(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1; 
    }
    int left = 0, right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (target == mid) {
        left = mid; 
      } else if (target < array[mid]) {
        right = mid; 
      } else {
        left = mid; 
      }
    }
    
    if(target == array[right]) {
      return right; 
    } else if (target == array[left]) {
      return left;
    } else {
      return -1; 
    }
  }
}
