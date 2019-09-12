package Facebook;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * @Time N
 * @Space N worst case
 */
public class MinimumAddtoMakeParenthesesValid {
    //
    public int minAddToMakeValidSol(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                close++;
            } else if (close > 0) {
                close--;
            } else {
                open++;
            }
        }

        return open + close;
    }

    // 1. if stack.peek == '(', currChar = ')' pop
    // 2. otherwise push
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peekLast() == '(' && ch == ')') {
                stack.pollLast();
            } else {
                stack.offerLast(ch);
            }
        }

        return stack.size();
    }
}
