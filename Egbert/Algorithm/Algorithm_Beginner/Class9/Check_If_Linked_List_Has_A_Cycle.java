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
 * slow and faster pointers
 * if there are A steps far away from slow and faster
 * if no circle, it will go untill null
 * otherwise, it will alway keep 1 steps regards the relative speed
 * assume the circle length is B, the worst case is O(B), so time complexity is O(N)
 * since there is no new object is created, so space complexity is O(1)
 **/
public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false; 
    }
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true; 
      }
    }
    return false;
  }
}

