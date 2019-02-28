package main.onlinejudges.leetcode.week1.PalindromeLinkedList;

public class PalindromeLinkedListFinal {

    public static boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        // Find mid
        ListNode mid = head;
        ListNode last = head.next;

        while(last != null && last.next != null) {
            mid = mid.next;
            last = last.next.next;
        }

        // debug
        System.out.println("mid queue");
        ListNode temp = mid;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }

        // Reverse last half
        ListNode previous = null;
        ListNode current = mid;

        while(current != null) {
            // Find next
            ListNode next = current.next;

            // Change pointer
            current.next = previous;

            // Move forward
            previous = current;
            current = next;
        }
        last = previous;

        // Compare
        boolean result = true;
        ListNode headCopy = head;
        ListNode lastCopy = last;
        while(head != null && last != null) {
            if(head.val != last.val) {
//                return false;
                result = false;
                break;
            }

            head = head.next;
            last = last.next;
        }

        // Debug
        System.out.println("head queue");
        while(headCopy != null){
            System.out.println(headCopy.val);
            headCopy = headCopy.next;
        }

        System.out.println("tail queue");
        while(lastCopy != null){
            System.out.println(lastCopy.val);
            lastCopy = lastCopy.next;
        }

        return result;

    }

    public static void main(String args[]) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
//        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = e;

//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        a.next = b;

        System.out.println(isPalindrome(a));

    }


}
