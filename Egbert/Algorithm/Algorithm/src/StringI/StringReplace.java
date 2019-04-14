package StringI;
import java.util.ArrayList;
/**
 * @author Egbert Li
 * @date 15/04/2019
 * Time: O(2 * N)
 * Space: O(1) worst: O(N)
 */
public class StringReplace {
    public String replace(String input, String source, String target) {
        if (input == null || input.length () == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        if (source.length() >= target.length()) {
            return replaceShorter(array, source, target);
        }
        return replaceLonger(array, source, target);
    }
    // if source.length >= target.length()
    private String replaceShorter(char[] array, String source, String target) {
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (fast <= array.length - source.length() && equalSubstring(array, fast, source)) {
                copySubstring(array, slow, target);
                slow += target.length();
                fast += source.length();
            } else {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
        }
        return new String(array, 0, slow);
    }

    // if source.length < target.length
    private String replaceLonger(char[] array, String source, String target) {
        ArrayList<Integer> matches = getAllMatches(array, source);
        char[] newArray = new char[array.length + matches.size() * (target.length() - source.length())];
        int lastIndex = matches.size() - 1;
        int fast = array.length - 1;
        int slow = newArray.length - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                slow -= target.length();
                fast -= source.length();
                copySubstring(newArray, slow + 1, target);
                lastIndex --;
            } else {
                newArray[slow] = array[fast];
                slow--;
                fast--;
            }
        }
        return new String(newArray);
    }

    // check if there is target exists
    private boolean equalSubstring(char[] array, int fromIndex, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (array[fromIndex + i] != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    // copy replace with target
    private void copySubstring(char[] array, int fromIndex, String target) {
        for (int i = 0; i < target.length(); i++) {
            array[fromIndex + i] = target.charAt(i);
        }
    }
    // get the all end positions of source string in input string
    private ArrayList<Integer> getAllMatches(char[] array, String source) {
        ArrayList<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= array.length - source.length()) {
            if (equalSubstring(array, i, source)) {
                matches.add(i + source.length() - 1);
                i += source.length();
            } else {
                i++;
            }
        }
        return matches;
    }
}
