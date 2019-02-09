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
        if node.left:
            self.trav(node.left)
        self.res.append(node.val)
        if node.right:
            self.trav(node.right)
            
    def inorderTraversal(self, root: 'TreeNode') -> 'List[int]':
        self.res = []
        if not root:
            return self.res
        self.trav(root)
        return self.res
