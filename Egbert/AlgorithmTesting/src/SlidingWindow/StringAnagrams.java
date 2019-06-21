package SlidingWindow;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6005911854252032
 * @author Egbert Li
 * @date 20/06/2019
 * @Time O M + N
 * @Space O M
 */
public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        if (str == null || pattern == null) {
            return resultIndices;
        }
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> charFreqMap = createCharFreqMap(pattern);
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1) ;
                if (charFreqMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == charFreqMap.size()) {
                resultIndices.add(windowStart);
            }
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
                windowStart++;
            }
        }
        return resultIndices;
    }
    public static Map<Character, Integer> createCharFreqMap(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return new HashMap<>();
        }
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char curLetter = pattern.charAt(i);
            charFreqMap.put(curLetter,
                    charFreqMap.getOrDefault(curLetter, 0 ) + 1);
        }
        return charFreqMap;
    }
    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
