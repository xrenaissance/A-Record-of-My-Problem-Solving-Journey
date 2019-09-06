package LinkedList;
import java.util.Map;
import java.util.HashMap;

/**
 * @leetcode https://leetcode.com/problems/copy-list-with-random-pointer/
 * @Time N
 * @Space N
 */
public class CopyListwithRandomPointer {
    // Solution 1: one pass
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode dummyHead = new RandomListNode(-1);
        RandomListNode curr = dummyHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.label));
            }
            curr.next = map.get(head);
            curr = curr.next;
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                    curr.random = map.get(head.random);
                } else {
                    curr.random = map.get(head.random);
                }
            }
            head = head.next;
        }
        return dummyHead.next;
    }
    // Solution 2: straight forward sol
    public RandomListNode copyRandomListst(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> copy = new HashMap<>();
        RandomListNode curr = head;
        while (curr != null) {
            copy.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            copy.get(curr).next = copy.get(curr.next);
            copy.get(curr).random = copy.get(curr.random);
            curr = curr.next;
        }
        return copy.get(head);
    }
}
