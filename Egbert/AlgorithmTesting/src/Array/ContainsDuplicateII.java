package Array;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/contains-duplicate-ii/
 * @date 27/7/2019
 * @Time N  worst
 * @Space N min(N,k)
 */
public class ContainsDuplicateII {
    // using set
    public boolean containsNearbyDuplicateSet(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    // Solution 2: HashMap solution
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // N
        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = map.put(nums[i], i);
            if (lastIndex != null && (i - lastIndex) <= k) {
                return true;
            }
        }
        return false;
    }
}
