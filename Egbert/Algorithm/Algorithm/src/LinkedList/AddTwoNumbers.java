package LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int j =0;
        while (l1 != null || l2 != null){
            if(l1 == null){
                res.next = new ListNode((j + l2.value) % 10);
                j = (j + l2.value) / 10;
                res = res.next;
                l2 = l2.next;
            } else if (l2 == null) {
                res.next = new ListNode((j + l1.value) % 10);
                j = (j + l1.value) / 10;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = new ListNode((j + l1.value + l2.value) % 10);
                j = (j + l1.value + l2.value) / 10;
                res = res.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(j == 1){
            res.next =new ListNode(j);
        }
        return head.next;
    }
}
