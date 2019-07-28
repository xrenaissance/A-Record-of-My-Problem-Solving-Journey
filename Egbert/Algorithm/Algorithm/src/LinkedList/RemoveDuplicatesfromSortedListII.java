package LinkedList;

/**
 * @leetcode https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * @date 28/7/2019
 * @Time N
 * @Space 1
 */
public class RemoveDuplicatesfromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode dummy = dummyHead;
    while (head != null) {
      if (head.next != null && head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        head = head.next;
      } else {
        dummy.next = head;
        dummy = dummy.next;
        head = head.next;
      }
      dummy.next = null;
    }
    return dummyHead.next;
  }
}
