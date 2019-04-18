package StringI;
import java.util.Set;
import java.util.HashSet;
/**
 * @author Egbert Li
 * @date 18/04/2019
 * Time: O 2N
 * Space: O n
 */
public class LongestSubstringWithKtypesCharacters {
    public String longest(String input, int k) {
        if (input == null) {
            return input;
        } else if (input.length() == 0) {
            return k == 0 ? "" : null;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        int start = 0;
        int end = 0;
        int longest = 0;
        Set<Character> records = new HashSet<>();
        while (fast < array.length) {
            records.add(array[fast]);
            if (records.size() <= k) {
                fast++;
                if (records.size() == k) {
                    if (fast - slow > longest) {
                        longest = fast - slow;
                        start = slow;
                        end = fast;
                    }
                }
            } else {
                char temp = array[slow];
                records.remove(array[slow]);
                while (array[slow] == temp) {
                    slow++;
                }
            }
        }
        return longest == 0 ? null : new String(array, start, longest);
    }
}
