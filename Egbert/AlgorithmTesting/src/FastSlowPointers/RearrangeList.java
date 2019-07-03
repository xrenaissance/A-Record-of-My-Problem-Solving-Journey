package FastSlowPointers;
import java.util.List;
public class RearrangeList {
    public static void reorder(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverse(secondHalf);
        ListNode curr = head;
        while (curr != null && secondHalf != null) {
            ListNode currNext = curr.next;
            ListNode secondNext = secondHalf.next;
            curr.next = secondHalf;
            secondHalf.next = currNext;
            curr = currNext;
            secondHalf = secondNext;
        }
    }
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}