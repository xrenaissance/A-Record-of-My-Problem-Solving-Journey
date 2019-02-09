# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def trav(self, node):
        if not node:
            return
        if node.val not in self.freq:
            self.freq[node.val] = 1
        else:
            self.freq[node.val] += 1
        self.trav(node.left)
        self.trav(node.right)
    
    def findMode(self, root: 'TreeNode') -> 'List[int]':
        self.freq = {}
        res = []
        if not root:
            return res
        self.trav(root)
        
        maximum = 0
        for val in self.freq:
            freq = self.freq[val]
            if freq > maximum:
                maximum = freq
                res = [val]
            elif freq == maximum:
                res.append(val)
        
        return res
