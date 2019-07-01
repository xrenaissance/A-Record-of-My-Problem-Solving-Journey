package FastSlowPointers;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/6360082440781824
 * @author Egbert Li
 * @date 1/7/2019
 * @Time O N
 * @Space O 1
 */
public class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int cycleDistance = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleDistance = getDistance(slow);
            }
        }
        return getCyclePoint(head, cycleDistance);
    }
    private static int getDistance(ListNode slow) {
        ListNode curr = slow;
        curr = curr.next;
        int distance = 1;
        while (curr != slow) {
            curr = curr.next;
            distance++;
        }
        return distance;
    }
    private static ListNode getCyclePoint(ListNode head, int distance) {
        ListNode slow = head;
        ListNode fast = head;
        while (distance > 0) {
            fast = fast.next;
            distance--;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
