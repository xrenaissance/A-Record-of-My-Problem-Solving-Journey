package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

/**
 * @leetcode https://leetcode.com/problems/max-stack/
 * @date 27/7/2019
 * @Time 1, n
 * @Space N
 */
public class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> max;
    public MaxStack() {
        stack = new LinkedList<>();
        max = new LinkedList<>();
    }

    public void push(int x) {
        int tempMax = max.isEmpty() ? Integer.MIN_VALUE : max.peekLast();
        if (x > tempMax) {
            tempMax = x;
        }
        stack.offerLast(x);
        max.offerLast(tempMax);
    }

    public int pop() {
        max.pollLast();
        return stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int peekMax() {
        return max.peekLast();
    }

    // almost constant
    public int popMax() {
        int currMax = max.peekLast();
        Deque<Integer> exchangeStack = new LinkedList<>();
        while (stack.peekLast() != currMax) {
            exchangeStack.offerLast(stack.pollLast());
            max.pollLast();
        }
        stack.pollLast();
        max.pollLast();
        while (!exchangeStack.isEmpty()) {
            push(exchangeStack.pollLast());
        }
        return currMax;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(-5);
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.popMax());
        System.out.println(maxStack.top());
    }
}
