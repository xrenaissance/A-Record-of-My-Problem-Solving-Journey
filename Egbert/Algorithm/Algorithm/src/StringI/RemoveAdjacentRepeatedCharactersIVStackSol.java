package StringI;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * @author Egbert Li
 * @date 14/04/2019
 * Time: O(n)
 * Space: O(n)
 */
public class RemoveAdjacentRepeatedCharactersIVStackSol {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int i = 1;
        stack.offerLast(array[0]);
        while (i < array.length) {
            if (!stack.isEmpty() && array[i] == stack.peekLast()) {
                while (i < array.length && array[i] == stack.peekLast()) {
                    i++;
                }
                stack.pollLast();
            } else {
                stack.offerLast(array[i]);
                i++;
            }
        }
        if (stack.isEmpty()) {
            return "";
        } else {
            int size = stack.size();
            int j = size - 1;
            while (!stack.isEmpty()) {
                array[j] = stack.pollLast();
                j--;
            }
            return new String(array, 0, size);
        }
    }
}
