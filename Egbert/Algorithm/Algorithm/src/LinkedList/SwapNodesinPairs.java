package LinkedList;

/**
 * @leetcode https://leetcode.com/problems/swap-nodes-in-pairs/
 * @date 26/7/2019
 * @Time N
 * @Space 1
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode dummy = dummyHead;
        while (head !=null && head.next != null) {
            ListNode next = head.next;
            ListNode nextNext = head.next.next;

            head.next = nextNext;
            next.next = head;
            dummy.next = next;
            dummy = head;
            head = nextNext;
        }
        return dummyHead.next;
    }
}
