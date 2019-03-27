package QueueAndStack;
import java.util.LinkedList;
import java.util.Deque;

/**
 * @author Egbert Li
 * @Date 27/03/2019
 *
 */
public class QueueByTwoStacks {
    Deque<Integer> in;
    Deque<Integer> out;

    /** Initialize your data structure here. */
    public QueueByTwoStacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void shuffleIfNecessary() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shuffleIfNecessary();
        if (out.isEmpty()) {
            return -1;
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        shuffleIfNecessary();
        if (out.isEmpty()) {
            return -1;
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
