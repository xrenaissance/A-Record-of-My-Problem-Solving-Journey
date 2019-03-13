package LinkedList;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode currNode = head;
        int length = 1;
        while (currNode.next != null) {
            currNode = currNode.next;
            length++;
        }
        if (n > length) {
            return head;
        }
        ListNode prev = null, curr = head;
        for (int i = 0; i < length - n; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            ListNode next = curr.next;
            prev.next = next;
            return head;
        }
        return head.next;
    }
}
