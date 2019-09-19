package Facebook;
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;
/**
 * @leetcode https://leetcode.com/problems/next-greater-element-i/
 * @Time m + n
 * @space m + n
 */
public class NextGreaterElementI {
    public int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();

        for (int num : nums2) {
            while (stack.size() > 0 && num > stack.peekLast()) {
                nextGreater.put(stack.pollLast(), num);
            }

            stack.offerLast(num);
        }

        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = nextGreater.getOrDefault(nums1[j], -1);
        }

        return nums1;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] stack = new int[nums2.length];
        int stackIndex = -1;
        int index = 0;

        while (index < nums2.length) {
            while (stackIndex >= 0 && nums2[index] > nums2[stack[stackIndex]]) {
                map.put(nums2[stack[stackIndex]], nums2[index]);
                stackIndex--;
            }

            stack[++stackIndex] = index++;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}
