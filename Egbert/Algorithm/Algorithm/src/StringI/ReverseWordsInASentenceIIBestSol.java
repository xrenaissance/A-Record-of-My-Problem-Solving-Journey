package StringI;

/**
 * @author Egbert Li
 * @date 16/04/2019
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseWordsInASentenceIIBestSol {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
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
                array[slow] = array[fast];
                slow++;
            }
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            return slow - 2;
        }
        return slow - 1;
    }
    private void reverse(char[] array, int left, int right) {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
