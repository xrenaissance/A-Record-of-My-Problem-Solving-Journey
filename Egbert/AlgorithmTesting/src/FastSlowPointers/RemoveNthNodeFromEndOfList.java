package FastSlowPointers;

/**
 * @leetcode https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @date 26/7/2019
 * @Time N
 * @Space 1
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (prev != null) {
            prev.next = slow.next;
            return head;
        }
        return head.next;
    }
}
