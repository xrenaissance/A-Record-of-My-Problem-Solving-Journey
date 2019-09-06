package LinkedList;

public class RunTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // connect all
        head.next = node2;
        node2.next = node3;
        printNode(head);
    }
    public static void printNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
    }
}
