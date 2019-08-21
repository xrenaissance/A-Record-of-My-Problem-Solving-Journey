package LinkedList;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/linked-list-cycle-ii/
 * @Time N
 * @Space N
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.add(head)) {
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }
}
