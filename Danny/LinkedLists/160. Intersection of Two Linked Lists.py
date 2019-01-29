# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # Dirty footprint entire linked list A
        backupA = headA
        while headA:
            headA.val = str(headA.val)
            headA = headA.next
        # Check if any of headB's nodes contain dirty footprint
        target = None
        while headB:
            if type(headB.val) is str:
                target = headB
                break
            headB = headB.next
    
        # Back to original int
        while backupA:
            backupA.val = int(backupA.val)
            backupA = backupA.next
            
        return target
