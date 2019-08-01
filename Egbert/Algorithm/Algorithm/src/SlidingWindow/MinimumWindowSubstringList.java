package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Time O m + n
 * @pace m
 */
public class MinimumWindowSubstringList {
    public static List<String> minWindow(String s, String t) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int windowStart = 0;
        Map<Character, Integer> charFreqMap = generateCharMap(t);
        int matched = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if (charFreqMap.get(rightChar) >= 0) {
                    matched++;
                }
            }
            while (matched == t.length()) {
                result.add(s.substring(windowStart, windowEnd + 1));
                char leftChar = s.charAt(windowStart++);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return result;
    }
    public static Map<Character, Integer> generateCharMap(String t) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            charFreqMap.put(currChar, charFreqMap.getOrDefault(currChar, 0) + 1);
        }
        return charFreqMap;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(MinimumWindowSubstringList.minWindow(s,t).toString());
    }
}
