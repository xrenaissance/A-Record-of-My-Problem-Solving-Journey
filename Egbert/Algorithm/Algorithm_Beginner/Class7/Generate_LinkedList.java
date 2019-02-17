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
  public ListNode generate(int n) {
    ListNode head = new ListNode(0);
    ListNode temp = head;
    int i = 1;
    while (i < n) {
      ListNode node = new ListNode(i);
      temp.next = node;
      temp = node;
      i++;
    }
    return head;
  }
}
