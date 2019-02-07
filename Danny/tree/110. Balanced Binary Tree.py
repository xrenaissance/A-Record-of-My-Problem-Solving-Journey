# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def get_depth(self, node, depth):
        """
        Get the depth the tree from the given node
        :rtype: integer
        """
        if not node:
            return depth
        return max(self.get_depth(node.left, depth+1), self.get_depth(node.right, depth+1))
    
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        left_depth = self.get_depth(root.left, 1)
        right_depth = self.get_depth(root.right, 1)
        if abs(left_depth - right_depth) <= 1:
            return self.isBalanced(root.left) and self.isBalanced(root.right)
        else:
            return False
        
        
        
        
