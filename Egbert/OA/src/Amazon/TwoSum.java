package Amazon;
import java.util.Map;
import java.util.HashMap;

/**
 * @link https://leetcode.com/problems/two-sum/
 * @author Egbert Li
 * @date 10/5/2019
 * Time: O(N)
 * Space: O(N)
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
