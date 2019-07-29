package String;

/**
 * @leetcode https://leetcode.com/problems/reverse-words-in-a-string/
 * @date 29/7/2019
 * @Time N
 * @Space N
 */
public class ReverseWordsInaString {
    public String reverseWords(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] array = str.toCharArray();
        int end = removeSpace(array);
        reverseWords(array, 0, end);
        return new String(array, 0, end + 1);
    }
    private void reverseWords(char[] array, int left, int right) {
        reverse(array, left, right);
        int start = left;
        for (int i = left; i <= right; i++) {
            if (array[i] == ' ') {
                reverse(array, start, i - 1);
                start = i + 1;
            }
        }
        reverse(array, start, right);
    }
    private int removeSpace(char[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            } else {
                array[slow++] = array[fast];
            }
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            return slow - 2;
        }
        return slow - 1;
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
