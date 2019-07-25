package LinkedList;

/**
 * @leetcode https://leetcode.com/problems/remove-linked-list-elements/
 * @date 26/7/2019
 * @Time N
 * @Space 1
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        while (head != null) {
            if (head.val != val) {
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;
        }
        dummy.next = head;
        return dummyHead.next;
    }
}
