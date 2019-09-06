package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @Time N
 * @Space N/3 --> N
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                stack.offerLast(stack.pollLast() + stack.pollLast());
            } else if (str.equals("-")) {
                stack.offerLast(-stack.pollLast() + stack.pollLast());
            } else if (str.equals("*")) {
                stack.offerLast(stack.pollLast() * stack.pollLast());
            } else if (str.equals("/")) {
                int second = stack.pollLast();
                int first = stack.pollLast();
                stack.offerLast(first/second);
            } else {
                stack.offerLast(Integer.parseInt(str));
            }
        }
        return stack.peekLast();
    }
    public static void main(String[] args) {
        String input = "1234";
        String input1 = "/";
        String input2 = "a12*";
        System.out.println(Integer.valueOf(input1));
    }
}
