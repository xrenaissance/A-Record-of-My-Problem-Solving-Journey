package Array;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/contains-duplicate-ii/
 * @date 27/7/2019
 * @Time N ^ 2 worst
 * @Space N
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // N
        for (int i = 0; i < nums.length; i++) {
            // N
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
