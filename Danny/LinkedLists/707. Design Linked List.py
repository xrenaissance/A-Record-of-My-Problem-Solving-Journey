class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        
class MyLinkedList(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = None
        self.length = 0

    def get(self, index):
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        :type index: int
        :rtype: int
        """
        if index < 0 or index >= self.length or not self.head:
            return -1
        current = self.head
        count = 0
        while current:
            if count == index:
                return current.val
            count += 1
            current = current.next
            
    def addAtHead(self, val):
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        :type val: int
        :rtype: void
        """
        new_node = ListNode(val)
        new_node.next = self.head
        self.head = new_node
        self.length += 1
        
    def addAtTail(self, val):
        """
        Append a node of value val to the last element of the linked list.
        :type val: int
        :rtype: void
        """
        new_node = ListNode(val)
        if not self.head:
            self.head = new_node
        else:
            current = self.head
            prev = None
            while current:
                prev = current
                current = current.next
            prev.next = new_node
        self.length += 1

    def addAtIndex(self, index, val):
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        :type index: int
        :type val: int
        :rtype: void
        """
        if index == 0:
            self.addAtHead(val)
        elif index == self.length:
            self.addAtTail(val)
        elif index > self.length or index < 0:
            return
        else:
            new_node = ListNode(val)
            count = 0
            current = self.head
            while current:
                count += 1
                if count == index:
                    next = current.next
                    current.next = new_node
                    new_node.next = next
                    break
                current = current.next

            self.length += 1
                    
        

    def deleteAtIndex(self, index):
        """
        Delete the index-th node in the linked list, if the index is valid.
        :type index: int
        :rtype: void
        """
        if index < self.length and index > 0:
            current = self.head
            prev = None
            count = 0
            while current:
                if count == index:
                    # Delete current node
                    prev.next = current.next
                    break
                count += 1
                prev = current
                current = current.next
            self.length -= 1

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
