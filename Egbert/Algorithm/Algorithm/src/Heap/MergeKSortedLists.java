package Heap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;

/**
 * @author Egbert Li
 * @date 28/05/2019
 * @Time total_size log k
 * @Space k
 */
public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        if (listOfLists == null) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode node : listOfLists) {
            minHeap.offer(node);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (!minHeap.isEmpty()) {
            curr.next = minHeap.poll();
            if (curr.next.next != null) {
                minHeap.offer(curr.next.next);
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            if (l1.value == l2.value) {
                return 0;
            }
            return l1.value < l2.value ? -1 : 1;
        }
    }
}
