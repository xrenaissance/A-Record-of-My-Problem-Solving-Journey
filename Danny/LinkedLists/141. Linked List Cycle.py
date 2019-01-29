# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        while head != None:
            if head.val == 12345611:
                return True
            else:
                head.val = 12345611
            head = head.next
        return False
