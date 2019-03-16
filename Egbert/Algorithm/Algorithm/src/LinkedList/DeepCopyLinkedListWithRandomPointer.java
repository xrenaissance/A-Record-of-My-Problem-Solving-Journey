package LinkedList;

public class DeepCopyLinkedListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return head;
        }

        Map<RandomListNode, RandomListNode> records = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;

        // start mirroring
        while (curr != null) {
            records.put(curr, new RandomListNode(curr.value));
            curr = curr.next;
        }
        curr = head;
        // load mirror
        while (curr != null) {
            records.get(curr).next = records.get(curr.next);
            records.get(curr).random = records.get(curr.random);
            curr = curr.next;
        }
        // return mirror head
        return records.get(head);
    }
}
