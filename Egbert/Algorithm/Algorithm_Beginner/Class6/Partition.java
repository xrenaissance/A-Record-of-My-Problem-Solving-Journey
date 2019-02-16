class Solution {
  public void swap(int[] array, int x, int y) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }
  
	public void partition(int[] array, int pivotIndex) {
    int left = 0;
    int right = array.length - 1;
    int pivotValue = array[pivotIndex];
    swap(array, pivotIndex, right);
    pivotIndex = left;
    for (; left < right; left++) {
     if (array[left] < pivotValue) {
       swap(array, pivotIndex, left);
       pivotIndex++;
     }
    }
    swap(array, pivotIndex, right);
  }
}
