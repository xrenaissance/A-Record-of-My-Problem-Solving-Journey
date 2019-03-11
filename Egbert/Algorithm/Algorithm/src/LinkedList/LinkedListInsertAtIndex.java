package LinkedList;

public class LinkedListInsertAtIndex {
    public ListNode insert(ListNode head, int index, int value) {
        if (head == null || index < 0) {
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            return newHead;
        }
        ListNode prev = null, curr = head;
        while (curr != null && index > 0) {
            prev = curr;
            curr = curr.next;
            index--;
        }
        ListNode newNode = new ListNode(value);
        if (curr != head && curr != null) {
            prev.next = newNode;
            newNode.next = curr;
        } else if (curr == head) {
            newNode.next = head;
            head = newNode;
        } else {
            prev.next = newNode;
        }
        return head;
    }
}
