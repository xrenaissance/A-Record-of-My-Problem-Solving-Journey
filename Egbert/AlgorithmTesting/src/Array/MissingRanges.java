package Array;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/missing-ranges/
 * @Time N
 * @space 2 * n
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            addRange(lower, upper, result);
            return result;
        }
        addRange(lower, (long)nums[0] - 1, result);
        for (int i = 1; i < nums.length; i++) {
            addRange((long)nums[i - 1] + 1, (long)nums[i] - 1, result);
        }
        addRange((long)nums[nums.length - 1] + 1, upper, result);
        return result;
    }
    private void addRange(long start, long end, List<String> result) {
        if (start > end) {
            return;
        }
        StringBuilder range = new StringBuilder();
        if (start == end) {
            range.append(start);
        } else {
            range.append(start).append("->").append(end);
        }
        result.add(range.toString());
    }
}
