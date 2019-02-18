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
import java.util.HashMap;
public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    HashMap<ListNode, Integer> records = new HashMap<ListNode, Integer>();
    records.put(head, 1);
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      if (!records.containsKey(next)) {
        records.put(next, 1);
      } else {
        return true;
      }
      curr = next;
    }
    return false;
  }
}
