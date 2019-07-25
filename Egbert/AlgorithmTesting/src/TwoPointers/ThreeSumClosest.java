package TwoPointers;
/**
 * @leetcode https://leetcode.com/problems/3sum-closest/
 * @date 26/7/2019
 * @Time n ^ 2
 * @Space 1
 */
import java.util.Arrays;
public class ThreeSumClosest {
    // Solution 1: clean code but in one method
    public int threeSumClosestClean(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }

    // Solution 2: my initial code
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] closest = new int[] {nums[0] + nums[1] + nums[nums.length - 1]};
        for (int i = 0; i < nums.length - 2; i++) {
            searchPairs(nums, i + 1, target - nums[i], closest);
        }
        return closest[0];
    }
    private void searchPairs(int[] nums, int left, int target, int[] closest) {
        int prevNum = nums[left - 1];
        // System.out.println(prevNum);
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                closest[0] = target + prevNum;
                System.out.println(closest[0]);
                return;
            }
            if (Math.abs(sum - target) <
                    Math.abs(closest[0]- target - prevNum)) {
                closest[0] =  + prevNum;
                // System.out.println(closest[0]);
            }
        }
    }
    public static void main(String[] args) {
        int[] input1 = new int [] {-1, 2, 1, -4};
        ThreeSumClosest tsc = new ThreeSumClosest();
        System.out.println(tsc.threeSumClosest(input1, 1));
    }
}
