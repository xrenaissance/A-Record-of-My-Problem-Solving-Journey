package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @leetcode https://leetcode.com/problems/intersection-of-two-arrays/
 * @Time M + N
 * @Space N
 *
 * Solution 2: binary search, sort first, then merge sort approach
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(k -> k).toArray();
    }
}
