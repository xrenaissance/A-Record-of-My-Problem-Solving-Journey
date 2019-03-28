package LinkedList;
/**
 * @author Egbert Li
 * @Date 28/03/2019 Second time
 */
public class ReverseLinkedListInPairsRecursion {
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currNode = head.next;
        ListNode newNode = reverseInPairs(currNode.next);
        currNode.next = head;
        head.next = newNode;
        return currNode;
    }
}
