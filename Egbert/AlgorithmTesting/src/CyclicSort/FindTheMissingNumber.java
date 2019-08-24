package CyclicSort;

/**
 * @leetcode https://leetcode.com/problems/missing-number/
 * @Time 2 * N
 * @Space 1
 */
public class FindTheMissingNumber {
    public static int findMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        while (index < nums.length) {
            while (nums[index] < nums.length && nums[index] != nums[nums[index]]) {
                swap(nums, index, nums [index]);
            }
            index++;
        }
        for ( int i = 0; i < nums.length; i++) {
            if ( nums [i] != i) {
                return i;
            }
        }
        return nums.length;
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
