public class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
    public void printLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " -> ");
        printLinkedList(head.next);
    }
}