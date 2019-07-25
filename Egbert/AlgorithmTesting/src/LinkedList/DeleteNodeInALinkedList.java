package LinkedList;

/**
 * @leetcode https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @date 26/7/2019
 * @Time O1
 * @Space 1
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
