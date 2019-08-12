package Sort;
import java.util.Arrays;

/**
 * @leetcode https://leetcode.com/problems/largest-number/
 * @Time nlogn
 * @Space N
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder res = new StringBuilder();
        for (String str : strNums) {
            res.append(str);
        }
        int index = 0;
        String output = res.toString();
        while (index < res.length() && output.charAt(index) == '0') {
            index++;
        }
        if (index == strNums.length) {
            return "0";
        }
        return output;
    }
}
