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
  public ListNode insertNode(ListNode head, int target) {
    if (head == null) {
      return new ListNode(target); 
    }
    ListNode curr = head;
    while (curr.next != null) {
      curr = curr.next; 
    }
    curr.next = new ListNode(target);
    return head;
  }
}
