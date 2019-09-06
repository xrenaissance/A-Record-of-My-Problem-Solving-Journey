package Design;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/moving-average-from-data-stream/
 * @Time 1
 * @Space window size
 */
public class MovingAveragefromDataStream {
    Deque<Integer> data;
    int currSum;
    final int windowSize;
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream(int size) {
        data = new LinkedList<>();
        windowSize = size;
    }

    public double next(int val) {
        if (data.size() < windowSize) {
            data.offerLast(val);
            currSum += val;
        } else {
            currSum = currSum - data.pollFirst() + val;
            data.offerLast(val);
        }
        return (double) currSum/data.size();
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
