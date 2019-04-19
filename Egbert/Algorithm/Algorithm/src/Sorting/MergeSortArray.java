package Sorting;

/**
 * @author Egbert Li
 * @date 1/4/2019 Third time
 * Time Complexity: O(1 + 2 + 4 + n/2) + O(n * log n) = O(n log n)
 * Space Complexity: O(n)
 */
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, 0 , array.length - 1,  helper);
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
        merge(array, helper, left, mid, right);
    }
    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid && j <= right) {
            if (helper[i] < helper[j]) {
                array[index] = helper[i];
                index ++;
                i ++;
            } else {
                array[index] = helper[j];
                j ++;
                index ++;
            }
        }
        while (i <= mid) {
            array[index] = helper[i];
            index ++;
            i ++;
        }
    }
}
