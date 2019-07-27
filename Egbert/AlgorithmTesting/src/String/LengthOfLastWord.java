package String;

/**
 * @leetcode https://leetcode.com/problems/length-of-last-word/
 * @date 27/7/2019
 * @Time N
 * @Space 1
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                length++;
            } else if (i + 1 < s.length() && Character.isLetter(s.charAt(i + 1))) {
                return length;
            }
        }
        return length;
    }
}
