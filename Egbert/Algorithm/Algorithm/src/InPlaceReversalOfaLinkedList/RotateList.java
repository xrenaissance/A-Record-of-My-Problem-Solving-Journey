package InPlaceReversalOfaLinkedList;

import java.util.List;

/**
 * @leetcode https://leetcode.com/problems/rotate-list/
 * @author Egbert Li
 * @date 7/7/2019
 * @Time O N
 * @Space O 1
 */
public class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null) {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        rotations %= length;
        int stepNeedToMove = length - rotations;
        ListNode prev = null;
        ListNode curr = head;
        while (stepNeedToMove > 0) {
            prev = curr;
            curr = curr.next;
            stepNeedToMove--;
        }
        if (prev != null) {
            prev.next = null;
            tail.next = head;
        }
        return curr;
    }
    // Solution 2, more elegant
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        curr.next = head;
        k %= length;
        for (int i = 0; i < length - k; i++) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
