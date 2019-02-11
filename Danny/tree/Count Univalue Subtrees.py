# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def check(self, node):
        if not node.left and not node.right:
            # Leaf node
            self.count += 1
            return node.val
        # Not a leaf node, keep going down
        sub_vals = []
        if node.left:
            sub_vals.append(self.check(node.left))
        if node.right:
            sub_vals.append(self.check(node.right))
        # print(node.val, self.count, sub_vals)
        if (len(sub_vals) == 1 and node.val == sub_vals[0]) or (len(sub_vals) == 2 and node.val == sub_vals[0] == sub_vals[1]):
            self.count += 1
            return node.val
            
    def countUnivalSubtrees(self, root: 'TreeNode') -> 'int':
        self.count = 0
        if not root:
            return 0
        self.check(root)
        return self.count
