package LinkedList;n
import java.util.Map;
import java.util.HashMap;

/**
 * @author Egbert Li
 * @date 16/5/2019
 * Time: O(n)
 * Space:  O(n)
 */
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
    public RandomListNode copyClean(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curr = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            // copy the current node if necessary
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            // connect the copied node to the deep copy list
            curr.next = map.get(head);
            // Copy the random node if necessary
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                curr.next.random = map.get(head.random);
            }
            head = head.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
