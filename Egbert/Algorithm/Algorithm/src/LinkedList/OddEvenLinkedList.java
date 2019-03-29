package LinkedList;

/**
 * @author Egbert Li
 * @date 30/03/2019
 * Time Complexity: O(n), Space Complexity: O(1)
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddCurr = odd;
        ListNode evenCurr = even;
        while (evenCurr != null && evenCurr.next != null) {
            ListNode oddNext = oddCurr.next.next;
            ListNode evenNext = evenCurr.next.next;
            oddCurr.next = oddNext;
            evenCurr.next = evenNext;
            oddCurr = oddNext;
            evenCurr = evenNext;
        }
        if (evenCurr != null) {
            evenCurr.next = null;
        }
        oddCurr.next = even;
        return odd;
    }
}
