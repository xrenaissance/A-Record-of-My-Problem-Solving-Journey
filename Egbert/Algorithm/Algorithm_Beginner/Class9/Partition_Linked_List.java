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
 * be careful
 * don't forget add l.next = null
 * */
public class Solution {
  public ListNode partition(ListNode head, int target) {
    ListNode smallNode = new ListNode(0);
    ListNode largeNode = new ListNode(1);
    ListNode s = smallNode, l = largeNode, curr = head;
    while (curr != null) {
      if (curr.value < target) {
        s.next = curr;
        s = curr;
      } else {
        l.next = curr;
        l = curr;
      }
      curr = curr.next;
    }
    s.next = largeNode.next;
    l.next = null;
    return smallNode.next;
  }
}
