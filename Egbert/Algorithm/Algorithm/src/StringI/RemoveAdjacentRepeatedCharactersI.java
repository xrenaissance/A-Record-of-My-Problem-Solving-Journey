package StringI;

/**
 * @author Egbert Li
 * @date 12/04/2019
 * Time: O(n)
 * Space O(1)
 */
public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        int slow = 0;
        char[] array = input.toCharArray();
        for (int fast = 0; fast < array.length; fast++) {
            if (fast > 0 && array[fast] == array[fast - 1]) {
                continue;
            } else {
                array[slow] = array[fast];
                slow++;
            }
        }
        //if (slow > 0 && array[slow] == array[slow - 1]) {
        //    return new String(array, 0, slow - 1);
        //}
        return new String(array, 0, slow);
    }
}
