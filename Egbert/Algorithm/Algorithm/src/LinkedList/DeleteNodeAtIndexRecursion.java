package LinkedList;
/**
 * @author Egbert Li
 * @date 30/03/2019
 * Time Complexity: O(n), O(n)
 */
public class DeleteNodeAtIndexRecursion {
    public ListNode deleteNode(ListNode head, int index) {
        if (head == null || index < 0) {
            return head;
        }
        if (index == 0 && head.next == null || index == 0) {
            return head.next;
        }

        ListNode curr = head;
        ListNode newNode = deleteNode(curr.next, index--);
        curr.next = newNode;
        return head;
    }
}
