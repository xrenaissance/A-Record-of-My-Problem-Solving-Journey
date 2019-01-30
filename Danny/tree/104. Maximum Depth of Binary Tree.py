# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def find_leaf(self, leaf, depth):
        if leaf:
            depth += 1
            if not leaf.left and not leaf.right:
                return depth
            elif not leaf.left:
                return self.find_leaf(leaf.right, depth)
            elif not leaf.right:
                return self.find_leaf(leaf.left, depth)
            else:
                return max(self.find_leaf(leaf.left, depth), self.find_leaf(leaf.right, depth))
        else:
            return depth
    
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        depth = 1
        return max(self.find_leaf(root.left, depth), self.find_leaf(root.right, depth))
