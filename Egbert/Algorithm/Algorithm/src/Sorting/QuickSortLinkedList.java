package Sorting;
import LinkedList.ListNode;
public class QuickSortLinkedList {
    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pivotNode = findMid(head);
        ListNode newHead = partition(head, pivotNode);

        ListNode prevNode = findNode(newHead, pivotNode);
        ListNode pivotNext = pivotNode.next;
        prevNode.next = null;

        ListNode firstHalf = head;
        ListNode secondHalf = pivotNext;

        ListNode sortedFirstHalf = quickSort(firstHalf);
        ListNode sortedSecondHalf = quickSort(secondHalf);
        ListNode firstHalfTail = findTail(sortedFirstHalf);
        firstHalfTail.next = pivotNode;
        pivotNode.next = sortedSecondHalf;

        return sortedFirstHalf;
    }

    private ListNode findTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    private ListNode findNode (ListNode head, ListNode target) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.value == target.value) {
                return currNode;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return prevNode;
    }

    private ListNode partition(ListNode head, ListNode target) {
        ListNode dummyHead = new ListNode(0);
        ListNode smallDummy = new ListNode(-1);
        ListNode largeDummy = new ListNode(1);
        ListNode dummy = dummyHead;
        ListNode small = smallDummy;
        ListNode large = largeDummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.value <= target.value) {
                small.next = curr;
                small = curr;
            } else {
                large.next = curr;
                large = curr;
            }
            curr = curr.next;
        }
        small.next = largeDummy.next;
        return smallDummy.next;
    }
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
