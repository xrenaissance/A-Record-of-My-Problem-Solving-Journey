package Subsets;
import java.util.Deque;
import java.util.LinkedList;
/**
 * @leetcode https://leetcode.com/problems/valid-parentheses/
 * @date 23/7/2019
 * @Time N
 * @Space N/2
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(')');
            } else if (s.charAt(i) == '[') {
                stack.offerLast(']');
            } else if (s.charAt(i) == '{') {
                stack.offerLast('}');
            } else if (stack.isEmpty() || s.charAt(i) != stack.pollLast()) {
                return false;
            }
        }
        return stack.isEmpty();
        LetterCombinationsOfAPhoneNumber}
}
