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
    ListNode curr = head;
    ListNode prev = curr;
    while (curr != null && target >= curr.value) {
      prev = curr;
      curr = curr.next;
    }
    
    ListNode node = new ListNode(target);
    if (curr != null) {
      prev.next = node;
      node.next = curr;
    } else {
      prev.next = node;
    }
    return head;
  }
}
