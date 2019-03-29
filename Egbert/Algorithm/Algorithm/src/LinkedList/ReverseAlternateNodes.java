package LinkedList;

/**
 * @author Egbert Li
 * @date 30/03/2019
 * Time Complexity: O(n), Space complexity: O(1)
 */
public class ReverseAlternateNodes {
    public ListNode reverseAlternate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = head.next;
        ListNode first = firstHalf;
        ListNode second = secondHalf;
        while (second != null && second.next != null) {
            ListNode firstNext = first.next.next;
            ListNode secondNext = second.next.next;
            first.next = firstNext;
            second.next = secondNext;
            first = firstNext;
            second = secondNext;
        }
        secondHalf = reverse(secondHalf);
        first.next = secondHalf;
        return firstHalf;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
