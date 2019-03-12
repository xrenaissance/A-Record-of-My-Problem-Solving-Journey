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
        if (curr == head) {
            newNode.next = head;
            return newNode;
        } else if (index == 0) {
            prev.next = newNode;
            newNode.next = curr;
        }
        return head;
    }
}
