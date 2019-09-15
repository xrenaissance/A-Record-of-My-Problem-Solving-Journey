package Facebook;
import java.util.Map;
import java.util.HashMap;
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int total = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (prefix.containsKey(sum - k)) {
                total += prefix.get(sum - k);
            }

            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}
