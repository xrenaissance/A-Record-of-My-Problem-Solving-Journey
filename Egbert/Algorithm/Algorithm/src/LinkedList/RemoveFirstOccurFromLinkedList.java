package LinkedList;

public class RemoveFirstOccurFromLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = head;
        ListNode dummy = dummyHead;
        while (curr != null) {
            if (curr.value != val) {
                dummy.next = curr;
                dummy = curr;
            } else {
                dummy.next = curr.next;
                break;
            }
            curr = curr.next;
        }
        //dummy.next = curr;
        return dummyHead.next;
    }
}
