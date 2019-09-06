public class Solution {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] copy = new int[array.length];
        mergeSort(array, copy, 0, array.length - 1);
        return array;
    }
    private void mergeSort(int[] array, int[] copy, int left, int right) {
        if (left >= right) {
            return; 
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, copy, left, mid);
        mergeSort(array, copy, mid + 1, right);
        for (int i = left; i <= right; i++) {
            copy[i] = array[i];
        }
        merge(array, copy, left, mid, right);
    }
    private void merge(int[] array, int[] copy, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (copy[i] < copy[j]) {
                array[k] = copy[i];
                i++;
                k++;
            } else {
                array[k] = copy[j];
                j++;
                k++;
            }
        }
        if (i <= mid) {
            array[k] = copy[i];
            k++;
            i++;
        }
    }
}
