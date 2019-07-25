package TwoPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5070198568648704
 * @leetcode https://leetcode.com/problems/remove-element/
 * @author Egbert Li
 * @date 23/06/2019 -> 26/7/2019
 * @Time O N
 * @Space O 1
 */
public class RemoveElement {
    public static int remove(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int nextNonKeyIndex = 0;
        // [0, slow) not val
        // [slow, fast) dump
        // [fast .. rest] explore
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextNonKeyIndex] = arr[i];
                nextNonKeyIndex++;
            }
        }
        return nextNonKeyIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemoveElement.remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemoveElement.remove(arr, 2));
    }
}