package Sorting;
import LinkedList.ListNode;

/**
 * @author Egbert Li
 * @date 2/04/2019
 * Time Complexity: average O (3 n) * log n ---> O(n log n), worst (3 * n) * n --> O(n ^ 2)
 * Space Complexity: O(1)
 */
public class QuickSortLinkedList {
    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftHalf = new ListNode(-1);
        ListNode midNode = new ListNode(0);
        ListNode rightHalf = new ListNode(1);
        ListNode left = leftHalf;
        ListNode mid = midNode;
        ListNode right = rightHalf;
        int pivot = head.value;

        while (head != null) {
            if (head.value < pivot) {
                left.next = head;
                left = head;
            } else if (head.value > pivot) {
                right.next = head;
                right = head;
            } else {
                mid.next = head;
                mid = head;
            }
            head = head.next;
        }
        left.next = null;
        right.next = null;
        mid.next = null;

        ListNode leftSorted = quickSort(leftHalf.next);
        ListNode rightSorted = quickSort(rightHalf.next);

        return merge(leftSorted, midNode.next, rightSorted);
    }

    // merge left, mid and right O(n)
    private ListNode merge(ListNode leftHalf, ListNode midNode, ListNode rightHalf) {
        ListNode leftTail = getTail(leftHalf); // O(n/2)
        ListNode midTail = getTail(midNode); // O(n/2)
        midTail.next = rightHalf;
        // O(1)
        if (leftTail != null) {
            leftTail.next = midNode;
            return leftHalf;
        } else {
            return midNode;
        }
    }

    // get tail of linked list O(n)
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return head;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}
