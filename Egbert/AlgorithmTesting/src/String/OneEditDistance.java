package String;

/**
 * @leetcode https://leetcode.com/problems/one-edit-distance/
 * @Time m + m
 * @Space 1
 */
public class OneEditDistance {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (Math.abs(sLength - tLength) > 1) {
            return false;
        }
        if (sLength > tLength) {
            return isOneEditDistance(t, s);
        }
        for (int i = 0; i < sLength; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLength == tLength) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return sLength != tLength;
    }
}
