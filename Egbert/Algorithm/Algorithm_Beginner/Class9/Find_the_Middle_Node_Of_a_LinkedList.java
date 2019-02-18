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
    int mid = getLength(head) / 2 + 1;
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
