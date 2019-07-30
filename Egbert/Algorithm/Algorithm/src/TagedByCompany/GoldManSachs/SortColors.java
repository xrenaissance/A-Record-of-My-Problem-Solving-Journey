package TagedByCompany.GoldManSachs;

/**
 * @leetcode https://leetcode.com/problems/sort-colors/
 * @Time N
 * @Space 1
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;
        // [0, zero) 0
        // [zero, one) 1
        // [one, two) explore
        // [two... rest] 2
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, zero++, one++);
            } else if (nums[one] == 1) {
                one++;
            } else {
                swap(nums, one, two--);
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
