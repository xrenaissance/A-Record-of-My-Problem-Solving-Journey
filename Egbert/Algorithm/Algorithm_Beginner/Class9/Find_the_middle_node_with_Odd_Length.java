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
 * slow pointer move 1 step ahead 
 * fast pointer move 2 steps ahead
 * if fast.next is null, it means slow pointer is already in middle Node of Linked List 
 * */
public class Solution {
  public ListNode findMiddleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head; 
    }
    ListNode slow = head.next, fast = head.next.next;
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
