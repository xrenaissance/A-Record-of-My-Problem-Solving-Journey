public class Solution {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length == 0) {
      return array; 
    }
    
    int[] helper = new int[array.length];
    mergeSort(array, 0, array.length - 1, helper);
    return array;
  }
  
  private void mergeSort(int[] array, int left, int right, int[] helper) {
    if (left >= right) {
      return; 
    }
    int mid = left + (right - left) / 2;
    
    mergeSort(array, left, mid, helper);
    mergeSort(array, mid + 1, right, helper);
    
    for (int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    int i = left, j = mid + 1, k = left;
    while (i <= mid && j <= right) {
      if (helper[i] < helper[j]) {
        array[k] = helper[i]; 
        i++;
      } else {
        array[k] = helper[j];
        j++;
      }
      k++;
    }
    while (i <= mid) {
      array[k] = helper[i];
      i++;
      k++;
    }
  }
}
