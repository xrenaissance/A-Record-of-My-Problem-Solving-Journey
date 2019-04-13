package StringI;

/**
 * @author Egbert Li
 * @date 14/04/2019
 * Time: O(N/2)
 * Space: O(N/2)
 */
public class ReverseString {
    public String reverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
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
