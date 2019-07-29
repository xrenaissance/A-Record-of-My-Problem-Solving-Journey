package LinkedList;

/**
 * @leetcode https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @date 29/7/2019
 * @Time 2 (N + M)
 * @space 1
 *
 * You can prove that: say A length = a + c,
 * B length = b + c, after switching pointer,
 * pointer A will move another b + c steps,
 * pointer B will move a + c more steps,
 * since a + c + b + c = b + c + a + c,
 * it does not matter what value c is.
 * Pointer A and B must meet after a + c + b (b + c + a) steps.
 * If c == 0, they meet at NULL.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        // c is the common length
        // a + c + b + c = b + c + a + c
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }
}
