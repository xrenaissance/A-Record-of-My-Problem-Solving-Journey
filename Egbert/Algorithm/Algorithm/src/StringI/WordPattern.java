package StringI;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @leetcode https://leetcode.com/problems/word-pattern/
 * @Time N
 * @Space N
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> pmap = new HashMap<>();
        Map<String, Integer> smap = new HashMap<>();
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String currStr = strArray[i];
            // if (pmap.get(ch) != null && smap.get(currStr) == null ||
            //     pmap.get(ch) == null && smap.get(currStr) != null) {
            //     return false;
            // } else if (pmap.get(ch) != null && smap.get(currStr) != null && !pmap.get(ch).equals(smap.get(currStr))) {
            //     return false;
            // }
            // if (pmap.put(ch, i) != smap.put(currStr, i)) {
            //     return false;
            // }
            if (!Objects.equals(pmap.put(ch, i), smap.put(currStr, i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        WordPattern.wordPattern(pattern, str);
    }
}
