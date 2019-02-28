package main.onlinejudges.leetcode.week1.PalindromeLinkedList;

import java.util.ArrayList;

public class PalindromeLinkedListSimple {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(head.val);

        while (head.next != null) {
            array.add(head.next.val);
            head = head.next;
        }

        boolean result = true;
        int start = 0;
        int end = array.size() - 1;
        while (start < end) {
            if (array.get(start) != array.get(end)) {
                result = false;
                break;
            }
        }
        return result;

    }


}
