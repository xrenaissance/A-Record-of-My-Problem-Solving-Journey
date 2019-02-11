# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def check(self, node, current):
        if not node:
            return False
        current += node.val
        if not node.left and not node.right:
            if current == self.target:
                return True
            return False
        return self.check(node.left, current) or self.check(node.right, current)
    
    def hasPathSum(self, root: 'TreeNode', sum: 'int') -> 'bool':
        if not root:
            return False
        self.target = sum
        return self.check(root, 0)
