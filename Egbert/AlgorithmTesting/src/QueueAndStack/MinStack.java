package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/min-stack/
 * @date 28/7/2019
 * @Time  all operations are O 1
 * @Space N
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        if (min.isEmpty() || x <= min.peekLast()) {
            min.offerLast(x);
        }
        stack.offerLast(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.pollLast() <= min.peekLast()) {
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
        return min.peekLast();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
        System.out.println(minStack.stack.peekLast() + " " + minStack.min.peekLast());
    }
}
