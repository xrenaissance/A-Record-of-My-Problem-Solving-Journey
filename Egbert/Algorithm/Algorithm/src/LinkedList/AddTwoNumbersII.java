package LinkedList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/add-two-numbers-ii/
 * @Time Time m + n
 * @Space m + n if using stack, otherwise 1
 */
public class AddTwoNumbersII {
    // Solution 1: Using Reverse
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode newHead = null;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            newHead = insertFront(newHead, sum % 10);
            sum /= 10;
        }
        if (sum != 0) {
            newHead = insertFront(newHead, sum % 10);
        }
        return newHead;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    private ListNode insertFront(ListNode head, int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        return newHead;
    }

    // Solution 2: Without Reverse
    public ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.offerLast(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offerLast(l2);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode newHead = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pollLast().val;
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pollLast().val;
            }
            newHead = insertFront(newHead, sum % 10);
            sum /= 10;
        }
        if (sum != 0) {
            newHead = insertFront(newHead, sum % 10);
        }
        return newHead;
    }
    public static void main(String[] args) {

    }
}
