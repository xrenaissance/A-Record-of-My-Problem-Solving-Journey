package DFS;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Egbert Li
 * @date 10/04/2019
 * Time complexity: n * n-1 * n-2 *....*1 = n!
 * Space complexity: O(height) --> O(n)
 */
public class AllPermutationsIDFS {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null || set.length() == 0) {
            return result;
        }
        char[] input = set.toCharArray();
        permutations(input, result, 0);
        return result;
    }
    private void permutations(char[] input, List<String> result, int index) {
        if (index == input.length) {
            result.add(new String(input));
            return;
        }
        for (int i = index; i < input.length; i++) {
            swap(input, i, index);
            permutations(input, result, index + 1);
            swap(input, i, index);
        }
    }
    private void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
