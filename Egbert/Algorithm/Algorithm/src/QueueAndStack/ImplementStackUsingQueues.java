package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Egbert Li
 * @Date 27/03/2019
 * For Push, every time time complexity is O(n)
 */
public class ImplementStackUsingQueues {
    Deque<Integer> queue;
    public ImplementStackUsingQueues() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue.offerLast(x);
        int i = 0;
        while (i < queue.size() - 1) {
            queue.offerLast(queue.pollFirst());
            i++;
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.pollFirst();
    }

    /** Get the top element. */
    public int top() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
