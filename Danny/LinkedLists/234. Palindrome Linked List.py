# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        # Sanity check
        if not head or not head.next:
            return True
        
        # Loop & Get the length of the linked list
        length = 0
        current = head
        while current:
            length += 1
            tail = current
            current = current.next
        
        # If the length is odd, delete the middle odd node.
        if length % 2:
            count = 0
            mid_count = length // 2
            current = head
            prev = None
            while current:
                # Zero based index
                if count == mid_count:
                    prev.next = current.next
                    break
                prev = current
                current = current.next
                count += 1
            
        # The linked list is even length
        # Get middle node
        current = head
        count = 0
        prev = None
        mid_count = length // 2
        while current:
            if count == mid_count:
                mid = current
                # Remove the link between the previous node to this mid node
                prev.next = None
            count += 1
            prev = current
            current = current.next
        # print "Mid", mid_count, " Length", length
        
        # Have 3 pointers: Head, Tail, Mid
        # Reverse from Mid to Tail node
        current = mid
        prev = None
        while current:
            next = current.next
            current.next = prev
            prev = current
            current = next
        
        while tail and head:
            # print "tail", tail.val, " head", head.val
            if tail.val != head.val:
                return False
            tail = tail.next
            head = head.next
        return True
