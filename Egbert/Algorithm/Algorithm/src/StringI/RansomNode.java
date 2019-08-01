package StringI;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode https://leetcode.com/problems/ransom-note/
 * @Time M + N
 * @Space 26
 */
public class RansomNode {
    // using array for record
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charFreq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charFreq[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (--charFreq[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    // HashMap solution
    public boolean canConstructHM(String ransomNote, String magazine) {
        if (ransomNote == null && magazine == null) {
            return true;
        } else if (ransomNote == null || magazine == null) {
            return false;
        } else if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int matched = 0;
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if (map.get(ch) != null && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                matched++;
                if (matched == ransomNote.length()) {
                    return true;
                }
            }
        }
        return matched == ransomNote.length();
    }
    public static void main(String[] args) {
        String str = "bjaajgea";
        String source = "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec";
        RansomNode.canConstruct(str, source);
    }
}
