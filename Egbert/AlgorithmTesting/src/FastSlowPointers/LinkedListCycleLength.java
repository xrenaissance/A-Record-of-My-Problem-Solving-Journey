package FastSlowPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6556337280385024
 * @author Egbert Li
 * @date 1/7/2019
 * @Time O N
 * @Space O 1
 */
public class LinkedListCycleLength {
    public static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // found the cycle
                return calculateLength(slow);
            }
        }
        return 0;
    }
    private static int calculateLength(ListNode slow) {
        ListNode curNode = slow.next;
        int length = 1;
        while (curNode != slow) {
            length++;
            curNode = curNode.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    }
}
