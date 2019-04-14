package StringI;

/**
 * @author Egbert Li
 * @date 14/04/2019
 * Time: O(n)
 * Space: O(1)
 */
public class ReverseWordsInASentense {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                reverse(array, start, i - 1);
                start = i + 1;
            }
        }
        reverse(array, start, array.length - 1);
        return new String(array);
    }
    private void reverse(char[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, right);
        reverse(array, left + 1, right - 1);
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
