package LinkedList;

public class RemoveDuplicatesFromSortedList {
    public ListNode removeDup(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(1);
        ListNode prev = null, curr = head, d = dummyNode;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            if (curr != null) {
                if (prev.value != curr.value) {
                    d.next = prev;
                    d = d.next;
                } else {
                    while (curr != null && curr.value == prev.value) {
                        curr = curr.next;
                    }
                    prev = curr;
                }
            }
        }
        d.next = prev;
        return dummyNode.next;
    }
}
