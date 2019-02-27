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
public class Solution {
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head; 
    }
    ListNode newNode = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newNode;
  }
}
