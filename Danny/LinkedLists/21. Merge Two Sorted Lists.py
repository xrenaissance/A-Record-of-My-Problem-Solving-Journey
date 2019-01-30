# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # Create an array
        res = []
        
        # Loop two linked lists until one of them reaches til the end
        while l1 and l2:
            val1 = l1.val
            val2 = l2.val
            
            if val1 == val2:
                res.extend([val1, val2])
                l1, l2 = l1.next, l2.next
                
            elif val1 > val2:
                res.append(val2)
                # Move l2 to next element
                l2 = l2.next
            
            elif val2 > val1:
                res.append(val1)
                # Move l1 to next element
                l1 = l1.next
            
        # Either one of the linked list has leftovers, or both have reached to the end
        while l1:
            res.append(l1.val)
            l1 = l1.next
        while l2:
            res.append(l2.val)
            l2 = l2.next
        
        # res should be a sorted array of the two linked lists
        # Create a new linkedlist and add the array into it
        if len(res) == 0:
            return None
        res_ll = head_node = ListNode(res[0])
        
        for idx in range(1, len(res)):
            new_node = ListNode(res[idx])
            res_ll.next = new_node
            res_ll = res_ll.next
        
        
        return head_node21. Merge Two Sorted Lists
