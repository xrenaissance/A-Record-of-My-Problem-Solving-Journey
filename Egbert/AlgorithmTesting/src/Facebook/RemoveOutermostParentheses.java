package Facebook;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/remove-outermost-parentheses/
 * @Time N
 * @Space N
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Deque<Character> stack = new LinkedList<>();
        StringBuilder sol = new StringBuilder();
        int index = 0;
        stack.offerLast(s.charAt(index++));
        while (index < s.length()) {
            if (s.charAt(index) == ')') {
                if (stack.size() - 1 == 0) {
                    stack.pollLast();
                    index++;
                } else {
                    stack.pollLast();
                    sol.append(s.charAt(index++));
                }
            } else {
                if (stack.size() == 0) {
                    stack.offerLast(s.charAt(index++));
                } else {
                    stack.offer(s.charAt(index++));
                    sol.append('(');
                }
            }
        }

        return sol.toString();
    }
}
