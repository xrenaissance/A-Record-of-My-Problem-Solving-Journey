/**
 * @author Egbert Li
 * @Date 22/03/2019
 */
public class MergeTwoSortedLinkedList {
    public static ListNode merge(ListNode one, ListNode two) {
        ListNode dummyNode = new ListNode(1);
        ListNode curr1 = one, curr2 = two, dummy = dummyNode;
        while (curr1 != null && curr2 != null) {
            if (curr1.value < curr2.value) {
                // ListNode next = curr1.next;
                dummy.next  = curr1;
                dummy = dummy.next;
                // curr1 = next;
                curr1 = curr1.next;
            } else {
                // ListNode next = curr2.next;
                dummy.next = curr2;
                dummy = dummy.next;
                // curr2 = next;
                curr2 = curr2.next;
            }
        }
        if (curr1 != null) {
            dummy.next = curr1;
        } else {
            dummy.next = curr2;
        }
        return dummyNode.next;
    }
}
