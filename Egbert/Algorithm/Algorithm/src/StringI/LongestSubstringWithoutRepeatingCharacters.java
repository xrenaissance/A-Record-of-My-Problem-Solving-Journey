package StringI;
import java.util.Set;
import java.util.HashSet;
/**
 * @author Egbert Li
 * @date 17/04/2019
 * Time: O(n)
 * Space: O(N)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Set<Character> currWindow = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()) {
            if (currWindow.add(input.charAt(fast))) {
                fast++;
                longest = Math.max(longest, fast - slow);
            } else {
                currWindow.remove(input.charAt(slow));
                slow++;
            }
        }
        return longest;
    }
}
