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
  public ListNode merge(ListNode one, ListNode two) {
    ListNode curr1 = one;
    ListNode curr2 = two;
    ListNode head = null;
    ListNode curr = null;
    while (curr1 != null && curr2 != null) {
      if (curr1.value < curr2.value) {
        ListNode node = new ListNode(curr1.value);
        if (head == null) {
          head = node;
          curr = head;
        } else {
          curr.next = node;
          curr = node;
        }
        curr1 = curr1.next;
      } else {
       ListNode node = new ListNode(curr2.value);
       if (head == null) {
         head = node;
         curr = head;
       } else {
         curr.next = node;
         curr = node;
       }
        curr2 = curr2.next;
      }
    }
    
    while (curr1 != null) {
      ListNode node = new ListNode(curr1.value);
      if (head == null) {
        head = node;
        curr = head;
      } else {
        curr.next = node;
        curr = node;
      }
      curr1 = curr1.next;
    }
    
    while (curr2 != null) {
      ListNode node = new ListNode(curr2.value);
      if(head == null) {
        head = node;
        curr = head;
      } else {
        curr.next = node;
        curr = node;
      }
      curr2 = curr2.next;
    }
    
    return head;
  }
}
