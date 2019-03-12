package LinkedList;

public class ReverseLinkedListInPairsIterative {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode slow = head, fast = head.next, d = dummyHead; // since head will be changed
        while (slow != null && fast != null) {
            ListNode next = fast.next;
            fast.next = slow;
            slow.next = next;
            d.next = fast;
            d = slow; // move dummy node 1 step ahead
            if (next != null) {
                slow = next;
                fast = next.next;
            } else {
                break;
            }
        }
        return dummyHead.next;
    }
}
