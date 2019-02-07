# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def find_path(self, node, current_path):
        current_path += "->%s" % node.val
        if not node.left and not node.right:
            # End path
            self.res.append(current_path)
        else:
            if node.left:
                self.find_path(node.left, current_path)
            if node.right:
                self.find_path(node.right, current_path)
    
    def binaryTreePaths(self, root: 'TreeNode') -> 'List[str]':
        if not root:
            return []
        self.res = []
        current_path = "%s" % root.val
        if not root.left and not root.right:
            return [current_path]
        if root.left:
            self.find_path(root.left, current_path)
        if root.right:
            self.find_path(root.right, current_path)
        return self.res
