package HashMap;

import java.util.HashMap;
import java.util.*;

/**
 * @leetcdoe https://leetcode.com/problems/word-abbreviation/
 * @Time N = size of dict M = average length of string
 * @Time N * M
 * @Space N
 */
public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> result = new ArrayList<>();
        if (dict == null || dict.size() == 0) {
            return result;
        }
        int round = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dict.size(); i++) {
            String currAbb = getAbbr(dict.get(i), round);
            result.add(currAbb);
            map.put(currAbb, map.getOrDefault(currAbb, 0) + 1);
        }
        while (true) {
            boolean unique = true;
            round++;
            for (int i = 0; i < result.size(); i++) {
                if (map.get(result.get(i)) > 1) {
                    String currAbb = getAbbr(dict.get(i), round);
                    result.set(i, currAbb);
                    map.put(currAbb, map.getOrDefault(currAbb, 0) + 1);
                    unique = false;
                }
            }
            if (unique) {
                break;
            }
        }
        return result;
    }
    private String getAbbr(String str, int position) {
        if (position + 2 >= str.length()) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        return res.append(str.substring(0, position))
                .append(str.length() - 1 - position)
                .append(str.charAt(str.length() - 1))
                .toString();
    }
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("like","god","internal","me",
                "internet","interval","intension","face","intrusion");

    }
}
