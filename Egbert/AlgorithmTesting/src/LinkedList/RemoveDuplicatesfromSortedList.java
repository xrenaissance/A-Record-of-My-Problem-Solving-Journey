package LinkedList;

/**
 * @leetcode https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * @date 28/7/2019
 * @Time N
 * @Space 1
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode dummy = dummyHead;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            dummy.next = head;
            dummy = dummy.next;
            head = head.next;
        }
        return dummyHead.next;
    }
}
