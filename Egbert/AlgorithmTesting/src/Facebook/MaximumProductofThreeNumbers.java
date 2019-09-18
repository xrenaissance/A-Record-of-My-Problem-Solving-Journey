package Facebook;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/maximum-product-of-three-numbers/
 * @Time N
 * @Space 1
 */
public class MaximumProductofThreeNumbers {
    // 3 positive -> 3 largest
    // 2 positive 1 negative -> 1 largets, 2 smallest
    // 1 positive 2 negative -> 1 largest, 2 smallest
    // 3 negative -> 3 largets
    public int maximumProductOn(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            // num < min1 < min2
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }


    // 3 positive -> 3 largest
    // 2 positive 1 negative -> 1 largets, 2 smallest
    // 1 positive 2 negative -> 1 largest, 2 smallest
    // 3 negative -> 3 largets
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
