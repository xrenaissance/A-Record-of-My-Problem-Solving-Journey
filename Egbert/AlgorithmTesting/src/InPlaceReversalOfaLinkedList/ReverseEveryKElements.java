package InPlaceReversalOfaLinkedList;

/**
 * @leetcode https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
 * @author Egbert Li
 * @date 6/7/2019
 * @Time O N
 * @Space O 1
 */
public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode dummy = dummyHead;
        ListNode prev = head;
        ListNode curr = findKth(head, k);
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;
            ReverseLinkedList.reverse(prev);
            prev.next = next;

            dummy.next = curr;
            dummy = prev;

            prev = next;
            curr = findKth(next, k);
        }
        dummy.next = ReverseLinkedList.reverse(prev);
        return dummyHead.next;
    }
    private static ListNode findKth(ListNode head, int k) {
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
