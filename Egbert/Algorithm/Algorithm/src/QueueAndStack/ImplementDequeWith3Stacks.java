package QueueAndStack;
import java.util.Deque;
import java.util.LinkedList;
public class ImplementDequeWith3Stacks<T> {
    public Deque<T> front;
    public Deque<T> back;
    public Deque<T> buffer;
    public ImplementDequeWith3Stacks() {
        front = new LinkedList<>();
        back = new LinkedList<>();
        buffer = new LinkedList<>();
    }
    public void offerFrist(T element) {
        front.offerFirst(element);
    }
    public T pollFirst() {
        if (front.isEmpty()) {

        }
    }
    public void offerLast(T element) {
        buffer.offerFirst(element);
    }
    public T pollLast() {

    }
}
