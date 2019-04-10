package DFS;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Egbert Li
 * @date 9/04/2019
 * Time complexity:
 * Space complexity:
 */
public class AllValidPermutationsOfParenthesesIDFS {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        StringBuilder sol = new StringBuilder();
        validParentheses(n, 0, 0, sol, result);
        return result;
    }
    private void validParentheses(int n, int left,
                                  int right, StringBuilder sol,
                                  List<String> result) {
        if (left == n && right == n) {
            result.add(sol.toString());
            return;
        }
        if (left < n) {
            // case1: add '('
            sol.append('(');
            validParentheses(n, left + 1, right, sol, result);
            sol.deleteCharAt(sol.length() - 1);

            // case2: don't add (
            //validParentheses(n, left, right, sol);
        }
        if (left > right) {
            sol.append(')');
            validParentheses(n, left, right + 1, sol, result);
            sol.deleteCharAt(sol.length() - 1);
        }
    }
}
