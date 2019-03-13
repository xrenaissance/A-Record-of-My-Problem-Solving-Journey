package LinkedList;

public class RotateListByKPlaces {
    public ListNode rotateKplace(ListNode head, int n) {
        if (head == null || head.next == null || n <= 0) {
            return head;
        }
        ListNode currNode = head;
        int length = 1;
        while (currNode.next != null) {
            currNode = currNode.next;
            length++;
        }
        currNode.next = head;
        n %= length;
        for (int i = 0; i < length - n; i++) {
            currNode = currNode.next;
        }
        ListNode newHead = currNode.next;
        currNode.next = null;
        return newHead;
    }
}
