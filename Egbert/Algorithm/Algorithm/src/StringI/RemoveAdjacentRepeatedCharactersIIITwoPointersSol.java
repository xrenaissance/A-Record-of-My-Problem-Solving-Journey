package StringI;

/**
 * @author Egbert Li
 * @date 13/04/2019
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveAdjacentRepeatedCharactersIIITwoPointersSol {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 1;
        while (fast < array.length) {
            if (slow >= 0 && array[fast] == array[slow]) {
                while (fast < array.length && array[fast] == array[slow]) {
                    fast++;
                }
                slow--;
            } else {
                slow++;
                array[slow] = array[fast];
                fast++;
            }
        }
        if (slow < 0) {
            return "";
        }
        return new String(array, 0, slow + 1);
    }
}
