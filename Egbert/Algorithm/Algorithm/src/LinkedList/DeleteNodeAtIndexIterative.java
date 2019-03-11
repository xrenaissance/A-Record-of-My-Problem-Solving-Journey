package LinkedList;

public class DeleteNodeAtIndexIterative {
    public ListNode deleteNode(ListNode head, int index) {
        if (head == null || index < 0) {
            return head;
        }
        ListNode prev = null, curr = head;
        while (curr != null && index > 0) {
            prev = curr;
            curr = curr.next;
            index--;
        }
        if (curr != head && curr != null) {
            prev.next = curr.next;
        } else if (curr == head) {
            return head.next;
        }
        return head;
    }
}
