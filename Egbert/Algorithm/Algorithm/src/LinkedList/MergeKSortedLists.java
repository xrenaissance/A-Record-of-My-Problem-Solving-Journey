package LinkedList;

public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        if (listOfLists == null || listOfLists.size() == 0) {
            return null;
        }

        // My dummy head
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;

        // My minHeap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        // Load to minHeap, O(nlogn)
        for (ListNode node : listOfLists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Then poll one by one each time 2 * log (total number of nodes)
        ListNode curr = null;
        while (!minHeap.isEmpty()) {
            curr = minHeap.poll();
            dummy.next = curr;
            dummy = dummy.next;
            if (curr.next != null) {
                curr = curr.next;
                minHeap.offer(curr);
            }
        }
        return dummyHead.next;
    }
}
