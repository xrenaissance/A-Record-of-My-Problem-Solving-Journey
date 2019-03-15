package LinkedList;

public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        if (head == null || value < head.value) {
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            return newHead;
        }

        ListNode prev = null, curr = head;
        while (curr != null) {
            if (curr.value > value) {
                break;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        prev.next = new ListNode(value);
        prev.next.next = curr;
        return head;
    }
}
