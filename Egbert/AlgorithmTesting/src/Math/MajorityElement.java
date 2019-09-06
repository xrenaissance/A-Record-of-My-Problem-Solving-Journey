package Math;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/majority-element/submissions/
 * @date 29/7/2019
 * @Time N
 * @space 1
 */
public class MajorityElement {
    // Moore voting algorithm
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {

                majority = nums[i];
                count++;
            } else if (nums[i] != majority) {
                count--;
            } else if (nums[i] == majority) {
                count++;
            }
        }
        return majority;
    }

    // Solution 2: HashMap solution
    public int majorityElementHM(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) + 1 > nums.length / 2) {
                return nums[i];
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return -1;
    }
}
