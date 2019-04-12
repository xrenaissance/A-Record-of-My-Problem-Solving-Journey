package StringI;
import java.util.*;

/**
 * @author Egbert Li
 * @date 12/04/2019
 * Time complexity: O(N)
 * Space complexity: O(unique number of letters in t)
 */
public class RemoveCertainCharactersInAString {
    public String remove(String input, String t) {
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(t);
        int slow = 0;
        for (int fast = 0; fast < input.length(); fast++) {
            if (!set.contains(array[fast])) {
                array[slow] = array[fast];
                slow++;
            }
        }
        return new String(array, 0, slow);
    }
    private Set<Character> buildSet(String t) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
}
