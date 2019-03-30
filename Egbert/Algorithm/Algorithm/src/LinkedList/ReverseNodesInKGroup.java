package LinkedList;

/**
 * @author Egbert Li
 * @date 30/03/2019
 * Time Complexity: O(N), space complexity: O(1)
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        ListNode prev = head;
        ListNode curr = findKth(head, k);
        dummy.next = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;

            reverse(prev);
            dummy.next = curr;
            prev.next = next;

            dummy = prev;
            prev = next;
            curr = findKth(next, k);
        }
        return dummyHead.next;
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
    private ListNode findKth(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }
}
