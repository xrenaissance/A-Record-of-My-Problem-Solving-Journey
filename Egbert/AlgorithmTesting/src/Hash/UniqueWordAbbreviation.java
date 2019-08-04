package Hash;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/unique-word-abbreviation/
 * @Time 1
 * @Space N,N
 */
public class UniqueWordAbbreviation {
    Map<String, Integer> strMap;
    Map<String, Integer> abbrMap;
    public UniqueWordAbbreviation(String[] dictionary) {
        strMap = new HashMap<>();
        abbrMap = new HashMap<>();
        for (String str : dictionary) {
            String abbr = getAbbr(str);
            strMap.put(str, strMap.getOrDefault(str, 0) + 1);
            abbrMap.put(abbr, abbrMap.getOrDefault(abbr, 0) + 1);
        }
    }

    public  boolean isUnique(String word) {
        return strMap.getOrDefault(word, 0) == abbrMap.getOrDefault(getAbbr(word), 0);
    }
    private String getAbbr(String str) {
        if (str.length() <= 2) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        return res.append(str.charAt(0))
                .append(str.length() - 2)
                .append(str.charAt(str.length() - 1))
                .toString();
    }
    public static void main(String[] args) {
        String[] dict = new String[]{"deer", "door", "cake", "card"};
        UniqueWordAbbreviation u = new UniqueWordAbbreviation(dict);
        System.out.println(u.isUnique("dear"));
    }
}
