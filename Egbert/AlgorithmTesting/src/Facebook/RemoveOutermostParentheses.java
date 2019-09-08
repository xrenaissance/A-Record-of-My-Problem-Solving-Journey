package Facebook;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/remove-outermost-parentheses/
 * @Time N
 * @Space 1
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sol = new StringBuilder();
        int index = 1;
        int open = 1;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                if (open != 0) {
                    sol.append('(');
                }
                open++;
            } else {
                if (open - 1 != 0) {
                    sol.append(')');
                }
                open--;
            }
            index++;
        }

        return sol.toString();
    }
}
