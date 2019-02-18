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
  public ListNode middleNode(ListNode head) {
    int length = getLength(head);
    if (length <= 1) {
      return head; 
    }
    
    int mid = 0;
    if (length % 2 == 1) {
      mid = length / 2 + 1; 
    } else {
      mid = length / 2; 
    }
    
    int i = 1;
    ListNode curr = head;
    while (i < mid) {
      curr = curr.next;
      i++;
    }
    return curr;
  }
  
  private int getLength(ListNode head) {
    if (head == null) {
      return 0; 
    }
    return 1 + getLength(head.next);
  }
}
