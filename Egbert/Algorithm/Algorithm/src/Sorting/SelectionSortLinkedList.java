package Sorting;
import LinkedList.ListNode;

/**
 * @author Egbert Li
 * @date 1/04/2019
 * Time Complexity: O(n ^ 2), Space Complexity: O(1)
 */
public class SelectionSortLinkedList {
    public ListNode selectionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode dummy = dummyNode;
        ListNode curr = head;

        // O(2n) * n ---> O(n ^ 2)
        while (curr != null) {
            ListNode minNode = findMin(curr); // O(n)
            dummy.next = minNode;
            dummy = minNode;
            curr = remove(curr, minNode); // O(n)
        }
        //dummy.next = curr;
        return dummyNode.next;
    }

    // O(n)
    private ListNode remove(ListNode head, ListNode target) {
        ListNode dummyNode = new ListNode(0);
        ListNode dummy = dummyNode;
        ListNode curr = head;
        while (curr != null) {
            if (curr.value != target.value) {
                dummy.next = curr;
                dummy = curr;
            } else {
                dummy.next = curr.next;
                break;
            }
            curr = curr.next;
        }
        return dummyNode.next;
    }

    // O(n)
    private ListNode findMin(ListNode head) {
        ListNode minNode = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.value < minNode.value) {
                minNode = curr;
            }
            curr = curr.next;
        }
        return minNode;
    }
}
