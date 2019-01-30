# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        # Loop through the linked list, if the next element exists and is a duplicate of the current one, then skip that one.
        cur = head
        while cur:
            if not cur.next:
                return head
            if cur.val == cur.next.val:
                cur.next = cur.next.next
            else:
                cur = cur.next
