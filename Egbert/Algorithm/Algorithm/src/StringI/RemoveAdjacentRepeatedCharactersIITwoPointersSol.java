package StringI;

/**
 * @author Egbert Li
 * @date 14/04/2010
 * Time: O(n)
 * Space: O(1)
 */
public class RemoveAdjacentRepeatedCharactersIITwoPointersSol {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 1;
        int flag = 1;
        while (fast < array.length) {
            if (array[fast] == array[slow] && flag < 2) {
                slow++;
                array[slow] = array[fast];
                fast++;
                flag++;
            } else if (array[fast] != array[slow]) {
                slow++;
                array[slow] = array[fast];
                fast++;
                flag = 1;
            } else {
                fast++;
            }
        }
        return new String(array, 0, slow + 1);
    }
}
