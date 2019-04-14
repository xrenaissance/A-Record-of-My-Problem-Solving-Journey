package StringI;

/**
 * @author Egbert Li
 * @date 14/04/2019
 * Time: O(2 * N)
 * Space: O(1)
 */
public class RightShiftByNCharactersBestSol {
    public String rightShift(String input, int n) {
        if (input == null || input.length() <= 1|| n <= 0) {
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - n - 1);
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
