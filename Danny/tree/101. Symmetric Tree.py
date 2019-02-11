# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def check(self, node_l, node_r):
        if not node_l and not node_r:
            return True
        if node_l and node_r and node_l.val == node_r.val:
            return self.check(node_l.left, node_r.right) and self.check(node_l.right, node_r.left)
        return False
    
    def isSymmetric(self, root: 'TreeNode') -> 'bool':
        if not root:
            return True
        return self.check(root.left, root.right)
