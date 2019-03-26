package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Egbert Li
 * @Date 27/03/2019
 * Time Complexity O(1), Space Complexity: O(n)
 */
public class StackWithMinPairSolution {
    Deque<Integer> stack;
    Deque<Pair<Integer, Integer>> minStack;
    public StackWithMinPairSolution () {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    // Define Pair Class
    public class Pair<T extends Object, F extends Object> {
        public T key;
        public F value;
        public Pair(T key, F value) {
            this.key = key;
            this.value = value;
        }
        public T getKey() {
            return this.key;
        }
        public F getValue() {
            return this.value;
        }
        public void setValue(F value) {
            this.value = value;
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int num = stack.pop();
        if (stack.size() == minStack.peek().getValue()) {
            minStack.pop();
        }
        return num;
    }

    public void push(int element) {
        if (minStack.isEmpty() || element < minStack.peek().getKey()) {
            minStack.push(new Pair<>(element, stack.size()));
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
        return minStack.peek().getKey();
    }
}
