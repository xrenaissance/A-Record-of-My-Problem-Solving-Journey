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
 * if you need to create new LinkedList, like 1 new linkedlist
 * when you merge two linkedlists, or 2 new linkedlists when you
 * partition a linked list
 * */
public class Solution {
  public ListNode merge(ListNode one, ListNode two) {
    ListNode dummyNode = new ListNode(1);
    ListNode c1 = one, c2 = two, d = dummyNode;
    while (c1 != null && c2 != null) {
      if (c1.value < c2.value) {
        d.next  = c1;
        d = c1;
        c1 = c1.next;
      } else {
        d.next = c2;
        d = c2;
        c2 = c2.next;
      }
    }
    if (c1 != null) {
      d.next = c1; 
    } else {
      d.next = c2; 
    }
    return dummyNode.next;
  }
}
