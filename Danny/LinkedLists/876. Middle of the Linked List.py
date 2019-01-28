# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def middleNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # Loop once to count the number of nodes
        # Then get the middle index and loop again to fetch that node
        # Best conceivable time complexity: O(N)
        cur = head
        total = 0
        while cur:
            total += 1
            cur = cur.next
        
        # 5 -> 3,  6 -> 4
        mid = total // 2 + 1
        
        cur = head
        count = 0
        while cur:
            count += 1
            if mid == count:
                return cur
            cur = cur.next
