package StringI;

/**
 * @leetcode https://leetcode.com/problems/number-of-segments-in-a-string/
 * @Time n
 * @Space 1
 */
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }
}
