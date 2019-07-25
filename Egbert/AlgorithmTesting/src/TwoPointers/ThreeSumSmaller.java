package TwoPointers;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/3sum-smaller/
 * @date 26/7/2019
 * @Time nlogn + n ^ 2
 * @Space n sorting
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int[] total = new int[1];
        for (int i = 0; i < nums.length - 2; i++) {
            // if (i > 0 && nums[i] == nums[i - 1]) {
            //     continue;
            // }
            searchPairs(nums, target - nums[i], i + 1, total);
        }
        return total[0];
    }
    private void searchPairs(int[] nums, int target, int left, int[] total) {
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                total[0] += right - left;
                left++;
            } else {
                right--;
            }
        }
    }
}
