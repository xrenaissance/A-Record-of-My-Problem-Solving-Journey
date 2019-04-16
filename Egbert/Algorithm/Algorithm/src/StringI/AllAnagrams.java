package StringI;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Egbert Li
 * @date 17/04/2019
 * Time: O(N)
 * Space: O(N)
 */
public class AllAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> result = new ArrayList<>();
        if (sh == null && lo == null ||
                sh == null || sh.length() == 0 ||
                lo == null || lo.length() == 0) {
            return result;
        } else if (sh.length() > lo.length()) {
            return result;
        }
        Map<Character, Integer> letterFreq = countMap(sh);
        int match = 0;
        for (int i = 0; i < lo.length(); i++) {
            char currLetter = lo.charAt(i);
            Integer count = letterFreq.get(currLetter);
            // handle the new added character(rightmost) at the current sliding window
            if (count != null) {
                letterFreq.put(currLetter, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            // handle the leftmost character at the previous sliding window
            if (i >= sh.length()) {
                currLetter = lo.charAt(i - sh.length());
                count = letterFreq.get(currLetter);
                if (count != null) {
                    // the number of needed count should be ++
                    // and only when the count is from 0 to 1, we are short for one
                    // match of distinct character
                    letterFreq.put(currLetter, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == letterFreq.size()) {
                result.add(i - sh.length() + 1);
            }
        }
        return result;
    }
    private Map<Character, Integer> countMap(String sh) {
        Map<Character, Integer> records = new HashMap<>();
        for (char ch : sh.toCharArray()) {
            records.put(ch, records.getOrDefault(ch, 0) + 1);
        }
        return records;
    }
}
