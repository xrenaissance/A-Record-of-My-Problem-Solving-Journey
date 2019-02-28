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
    if (head == null || target < head.value) {
      ListNode newHead = new ListNode(target);
      newHead.next = head;
      return newHead;
    }
    ListNode prev = null, curr = head;
    while (curr != null) {
      if (curr.value >= target) {
        break; 
      } else {
        prev = curr;
        curr = curr.next;
      }
    }
    prev.next = new ListNode(target);
    prev.next.next = curr;
    return head;
  }
}
