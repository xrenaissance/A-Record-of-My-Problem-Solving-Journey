package LinkedList;

/**
 * @author Egbert Li
 * @Date 28/03/2019
 * Third Time
 */
public class ReverseLinkedListInPairsIterative {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode dummy = dummyHead;
        while (prev != null && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev.next = next;
            dummy.next = curr;
            dummy = prev;
            if (next != null) {
                prev = next;
                curr = next.next;
            } else {
                break;
            }
        }
        return dummyHead.next;
    }
}
