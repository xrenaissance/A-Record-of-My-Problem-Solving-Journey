package StringI;

/**
 * @leetcode https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * @date 29/7/2019
 * @Time N
 * @Space 1
 */
public class ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length - 1);
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverse(s, start, end - 1);
            start = end + 1;
        }
    }
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            swap(s, start++, end--);
        }
    }
    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
