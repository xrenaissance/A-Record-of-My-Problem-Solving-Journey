package Hash;

/**
 * @leetcode https://leetcode.com/problems/first-unique-character-in-a-string/
 * @Time N
 * @Space 128
 */
public class FirstUniqueCharacterinaString {
    /**
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] charFreq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charFreq[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
