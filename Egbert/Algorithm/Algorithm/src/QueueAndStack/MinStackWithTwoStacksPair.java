package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/min-stack/
 * @date 29/7/2019
 * @Time 1 for all of operations
 * @Space N worst
 */
public class MinStackWithTwoStacksPair {
    Deque<Integer> stack;
    Deque<Pair> min;
    public MinStackWithTwoStacksPair() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {

        if (min.isEmpty() || x <= min.peekLast().key) {
            min.offerLast(new Pair(x, stack.size()));
        }
        stack.offerLast(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pollLast();
        if (stack.size() == min.peekLast().value) {
            min.pollLast();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekLast();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peekLast().key;
    }
    public static class Pair {
        int key;
        int value;
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
