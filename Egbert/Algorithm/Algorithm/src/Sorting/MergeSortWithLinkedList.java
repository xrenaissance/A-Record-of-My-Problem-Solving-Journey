package Sorting;

import LinkedList.ListNode;
/**
 * @author Egbert Li
 * @date 1/04/2019
 * Time Complexity: O(n * logn) + O(n) * log n ---> O(n log n)
 * Space Complexity: O (1)
 */
public class MergeSortWithLinkedList {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = findMid(head); // O(n)
        ListNode midNext  = midNode.next;
        midNode.next = null;
        ListNode firstHalf = head;
        ListNode secondHalf = midNext;

        ListNode sortedFirst = mergeSort(firstHalf);
        ListNode sortedSecond = mergeSort(secondHalf);

        return merger(sortedFirst, sortedSecond);
    }

    // merge two sorted linked list O(N)
    private ListNode merger(ListNode one, ListNode two) {
        ListNode currOne = one;
        ListNode currTwo = two;
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        while (currOne != null && currTwo != null) {
            if (currOne.value < currTwo.value) {
                dummy.next = currOne;
                dummy = currOne;
                currOne = currOne.next;
            } else {
                dummy.next = currTwo;
                dummy = currTwo;
                currTwo = currTwo.next;
            }
        }
        if (currOne != null) {
            dummy.next = currOne;
        } else if (currTwo != null) {
            dummy.next = currTwo;
        }
        return dummyHead.next;
    }

    // find mid node O(n)
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
