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
    if (head == null) {
      return head;
    }
    ListNode curr = head;
    ListNode next = head.next;
    ListNode nextNext = null;
    while (next != null) {
      if (next.next != null) {
        nextNext = next.next; 
      } else {
        nextNext = null;
      }
      next.next = curr;
      if (curr == head) {
        curr.next = null; 
      }
      curr = next;
      next = nextNext;
    }
    return curr;
  }
}
