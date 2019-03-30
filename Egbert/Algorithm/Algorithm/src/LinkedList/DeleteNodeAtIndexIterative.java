package LinkedList;

public class DeleteNodeAtIndexIterative {
    public ListNode deleteNode(ListNode head, int index) {
        if (head == null || index < 0) {
            return head;
        }
        if (index == 0) {
            return head.next;
        }
        ListNode curr = head, prev = null;
        while (curr != null && index > 0) {
            prev = curr;
            curr = curr.next;
            index--;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
        return head;
    }
}
