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

/**
 * @leetcode https://leetcode.com/problems/remove-linked-list-elements/
 * @date 26/7/2019
 * @Time N
 * @Space 1
 */
public class RemoveLinkedListElemens {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode d = dummyHead; 
        ListNode curr = head;
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
