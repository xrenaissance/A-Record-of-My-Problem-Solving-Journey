package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Egbert Li
 * @Date 26/03/2019
 * Implemented with two stacks, if element is smaller than
 * stack.peek and current min, then push both
 */
public class StackWithMinNaiveTwoStacks {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public StackWithMinNaiveTwoStacks() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int num = stack.pop();
        if (num <= minStack.peek()) {
            minStack.pop();
        }
        return num;
    }

    public void push(int element) {
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }
        stack.push(element);
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
