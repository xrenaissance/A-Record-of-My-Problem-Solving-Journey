package LinkedList;

/**
 * @author Egbert Li
 * @date 30/03/2019
 * Time Complexity: O(N), Space complexity: O(1)
 */
public class DeleteNodesAtIndices {
    public ListNode deleteNodes(ListNode head, int[] indices) {
        if (head == null || indices == null || indices.length == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        ListNode curr = head;
        int i = 0;
        int kth = 0;

        while (curr != null && i < indices.length) {
            ListNode next = curr.next;
            if (kth == indices[i]) {
                i++;
            } else {
                dummy.next  = curr;
                dummy = curr;
            }
            curr = next;
            kth++;
        }
        dummy.next = curr;
        return dummyHead.next;
    }
}
