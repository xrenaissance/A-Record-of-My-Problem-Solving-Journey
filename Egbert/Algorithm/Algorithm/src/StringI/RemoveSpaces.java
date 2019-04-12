package StringI;

/**
 * @author Egbert Li
 * @date 12/04/2019
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveSpaces {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            // two cases that don't need to copy the letter
            // case 1: array slow = 0
            // case 2: fast consecutive spaces
            if(array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            }
            array[slow] = array[fast];
            slow++;
        }
        // when loop stopped, there is extra space is copied
        // so need to check if array[slow - 1] == ' '
        if (slow > 0 && array[slow - 1] == ' ') {
            return new String(array, 0, slow - 1);
        }
        return new String(array, 0, slow );
    }
}
