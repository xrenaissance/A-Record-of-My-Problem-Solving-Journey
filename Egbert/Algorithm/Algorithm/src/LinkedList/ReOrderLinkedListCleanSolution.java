package LinkedList;

/**
 * @author Egbert Li
 * @Date 29/03/2019
 * Third Time
 */
public class ReOrderLinkedListCleanSolution {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode secondHalf = reverse(midNext);
        return merger(head, secondHalf);
    }

    // Find Mid Node
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Reverse Linked List
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

    // Merger Two LinkedList
    private ListNode merger(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        dummy.next = one;
        while (two != null) {
            ListNode oneNext = one.next;
            ListNode twoNext = two.next;
            one.next = two;
            two.next = oneNext;
            one = oneNext;
            two = twoNext;
        }
        return dummyHead.next;
    }
}
