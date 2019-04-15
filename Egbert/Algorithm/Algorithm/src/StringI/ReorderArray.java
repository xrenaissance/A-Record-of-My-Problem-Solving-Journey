package StringI;

/**
 * @author Egbert Li
 * @date 16/04/2019
 * Time: O(NlogN)
 * Space(log N);
 */
public class ReorderArray {
    public int[] reorder(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length % 2 == 0 ? array.length - 1 : array.length - 2;
        reorder(array, left, right);
        return array;
    }
    private void reorder(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 2) {
            return;
        }
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + 3 * size / 4;
        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);
        reorder(array, left, left + 2 * (leftMid - left) - 1);
        reorder(array, left + 2 * (leftMid - left), right);
    }
    private void reverse(int[] array, int left, int right) {
        while (left <= right) {
            swap(array, left, right);
            left ++;
            right --;
        }
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
