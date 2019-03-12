package LinkedList;

public class RemoveDuplicatesFromSortedList {
    public ListNode removeDup(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, curr = head;
        while (curr != null) {
            while (curr != null && curr.value == prev.value) {
                curr = curr.next;
            }
            prev.next = curr;
            prev = curr;
        }
        return head;
    }
}
