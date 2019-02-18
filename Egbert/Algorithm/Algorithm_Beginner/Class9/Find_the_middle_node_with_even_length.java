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
  public ListNode findMiddleNode(ListNode head) {
    int mid = getLength(head) / 2;
    ListNode curr = head;
    int i = 1;
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
