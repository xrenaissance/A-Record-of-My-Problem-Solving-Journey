package RecursionII;
import LinkedList.ListNode;

/**
 * @author Egbert Li
 * @date 11/04/2019
 * Time Complexity: O(n)
 * Space Complexity O(n)
 */
public class RverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        ListNode newNode = reverseInPairs(next);
        curr.next = prev;
        prev.next = newNode;
        return curr;
    }
}
