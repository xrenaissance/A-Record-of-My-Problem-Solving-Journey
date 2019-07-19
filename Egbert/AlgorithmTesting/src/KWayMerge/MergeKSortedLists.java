package KWayMerge;

import java.util.PriorityQueue;

/**
 * @leetcode https://leetcode.com/problems/merge-k-sorted-lists/
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/4611799594827776
 * @date 19/7/2019
 * @Time N log K   N = total number of elements in all the K input arrays
 * @Space K   at any time, minHeap will be storing one number from all the k input arrays
 */
public class MergeKSortedLists {
    public static ListNode merge(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        if (lists == null || lists.length == 0) {
            return result.next;
        }
        int length = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            length, (n1, n2) -> n1.value - n2.value
        );
        // N log N
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
           }
        }
        ListNode curr = result;
        // T log N
        while (!minHeap.isEmpty()) {
            ListNode currNode = minHeap.poll();
            curr.next = currNode;
            curr = curr.next;
            if (currNode.next != null) {
                minHeap.offer(currNode.next);
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
