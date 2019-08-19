package MergeIntervals;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/my-calendar-i/
 * @Time logn
 * @Space n
 */
public class MyCalendarI {
    TreeMap<Integer, Integer> bookings;
    public MyCalendarI() {
        bookings = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (bookings.size() == 0) {
            bookings.put(start, end);
            return true;
        }
        Integer lowStart = bookings.floorKey(start);
        if (lowStart != null && bookings.get(lowStart) > start) {
            return false;
        }
        Integer highStart = bookings.ceilingKey(start);
        if (highStart != null && highStart < end) {
            return false;
        }
        bookings.put(start, end);
        return true;
    }
}
