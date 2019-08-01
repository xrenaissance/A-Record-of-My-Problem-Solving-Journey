package Array;

import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * @Time M + N/HashMap
 * @Space M+D/HashMap Solution
 *
 * Q: What if the given array is already sorted?
 * How would you optimize your algorithm?
 * A: If both arrays are sorted, I would use two pointers to iterate,
 * which somehow resembles the merge process in merge sort.
 *
 * Q: What if nums1's size is small compared to nums2's size?
 * Which algorithm is better?
 * A: lengths of two arrays are N and M, the time complexity of
 * my solution is O(N+M) and the space complexity if O(N)
 * considering the hash. So it's better to use the smaller array to
 * construct the counter hash.
 *
 * Q: Follow up: What if elements of nums2 are stored on disk,
 *     and the memory is limited such
 *     that you cannot load all elements into the memory at once?
 * A: If only nums2 cannot fit in memory, put all elements of
 * nums1 into a HashMap, read chunks of array that fit into the
 * memory, and record the intersections.
 * If both nums1 and nums2 are so huge that neither
 * fit into the memory, sort them individually (external sort),
 * then read 2 elements from each array at a time in memory, record intersections.
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82243/Solution-to-3rd-follow-up-question
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.get(num) != null && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] output = new int[result.size()];
        int j = 0;
        for (int num : result) {
            output[j++] = num;
        }
        return output;
    }

    // Solution 2: Binary Search
    public int[] intersectBS(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]){
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] output = new int[result.size()];
        int k = 0;
        for (int num : result) {
            output[k++] = num;
        }
        return output;
    }
}
