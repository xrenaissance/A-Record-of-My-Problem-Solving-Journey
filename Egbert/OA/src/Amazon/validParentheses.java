package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * @link https://leetcode.com/problems/valid-parentheses/
 * Time: O N
 * Space: O N/2
 */
public class validParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(')');
            } else if (s.charAt(i) == '{') {
                stack.offerLast('}');
            } else if (s.charAt(i) == '[') {
                stack.offerLast(']');
            } else if (stack.isEmpty() || stack.pollLast() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
