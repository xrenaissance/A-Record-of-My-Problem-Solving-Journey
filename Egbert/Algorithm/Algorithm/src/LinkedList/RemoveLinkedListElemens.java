package LinkedList;

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class RemoveLinkedListElemens {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode d = dummyHead, curr = head;
        while (curr != null) {
            if(curr.value != val) {
                d.next = curr;
                d = d.next;
            }
            curr = curr.next;
        }
        d.next = curr;
        return dummyHead.next;
    }
}
