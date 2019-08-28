package TagedByCompany.Facebook;

import java.util.Random;

/**
 * @leetcode https://leetcode.com/problems/sort-an-array/
 * @Time NlogN average
 * @Space 1
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int privotIndex = partition(nums, left, right);
        quickSort(nums, left, privotIndex - 1);
        quickSort(nums, privotIndex + 1, right);
    }
    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int randIndex = random.nextInt(right - left + 1) + left;
        swap(nums, randIndex, right);
        int smaller = left;
        int larger = left;
        // [0, smaller)  num <= right
        // [smaller, larger) > right
        // [larger, rest] to explore
        while (larger < right) {
            if (nums[larger] <= nums[right]) {
                swap(nums, smaller++, larger++);
            } else {
                larger++;
            }
        }
        swap(nums, smaller, right);
        return smaller;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
