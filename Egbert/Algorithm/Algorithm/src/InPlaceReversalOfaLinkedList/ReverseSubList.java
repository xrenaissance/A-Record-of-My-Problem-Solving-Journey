package InPlaceReversalOfaLinkedList;

/**
 * @leetcode https://leetcode.com/problems/reverse-linked-list-ii/
 * @author Egbert Li
 * @date 5/7/2019
 * @Time O N
 * @Space O 1
 */
public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode curr = dummyHead.next;
        int i = 1;
        while (i < p) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode lastNodeOfFirstPart = prev;
        // d -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        //      l    c
        while (i <= q) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        lastNodeOfFirstPart.next.next = curr;
        lastNodeOfFirstPart.next = prev;
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
