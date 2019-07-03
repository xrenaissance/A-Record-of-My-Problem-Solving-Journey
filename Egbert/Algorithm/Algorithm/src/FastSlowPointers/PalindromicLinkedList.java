package FastSlowPointers;

/**
 * @link https://leetcode.com/problems/palindrome-linked-list/
 * @author Egbert Li
 * @date 3/7/2019
 * @Time O N
 * @Space O 1
 */
public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextHead = slow.next;
//        1 2 3 4
//          s   f
//        1 2 3 null
//          s    f
        if (fast != null) {
            slow.next = null;
        } else {
            pre.next = null;
        }
        ListNode secondList  = reverse(nextHead);
        System.out.println();
        printLinkedList(head);
        printLinkedList(secondList);
        return isSameLinkedList(head, secondList);
    }
    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static boolean isSameLinkedList(ListNode head1, ListNode head2) {
        while (head2 != null) {
            if (head1.value != head2.value) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
