package StringI;

/**
 * @author Egbert Li
 * @date 14/04/2019
 * Time: O((n ^ 2))
 * Space: O(1)
 */
public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        if (input == null || input.length() <= 1|| n <= 0) {
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
        while (n > 0) {
            move(array);
            n--;
        }
        return new String(array);
    }
    private void move(char[] array) {
        int end = array.length - 1;
        while (end >= 0 && end - 1 >= 0) {
            swap(array, end, end - 1);
            end--;
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
