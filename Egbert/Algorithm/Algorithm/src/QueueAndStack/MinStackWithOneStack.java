package QueueAndStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStackWithOneStack {
    int min = Integer.MIN_VALUE;
    Deque<Integer> stack;
    public MinStackWithOneStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty() || x <= min) {
            stack.offerLast(min);
            min = x;
        }
        stack.offerLast(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.pollLast() == min) {
            min = stack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return this.min;
    }
}
