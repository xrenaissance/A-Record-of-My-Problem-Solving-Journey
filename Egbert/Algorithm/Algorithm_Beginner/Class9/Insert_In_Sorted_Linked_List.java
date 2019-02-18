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
  public ListNode insert(ListNode head, int value) {
    if (head == null) {
      return new ListNode(value); 
    }
    ListNode curr = head;
    ListNode prev = null;
    while (curr != null && value >= curr.value) {
      prev = curr;
      curr = curr.next;
    }
    
    ListNode node = new ListNode(value);
    if (prev == null) {
      node.next = curr;
      head = node;
    } else if (prev != null && curr != null) {
      prev.next = node;
      node.next = curr;
    } else {
      prev.next = node; 
    }
    return head;
  }
}
