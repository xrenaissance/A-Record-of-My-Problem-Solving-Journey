# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def builder(self, parent_node, inorder, direction):
        if not inorder:
            return
        current_root = TreeNode(self.postorder.pop())
        if direction == 1:
            parent_node.right = current_root
        else:
            parent_node.left = current_root
        
        l_inorder, r_inorder = inorder[:inorder.index(current_root.val)], inorder[inorder.index(current_root.val)+1:]
        
        # Start construction from right subtree
        self.builder(current_root, r_inorder, 1)
        self.builder(current_root, l_inorder, -1)
        
    def buildTree(self, inorder: 'List[int]', postorder: 'List[int]') -> 'TreeNode':
        if not inorder and not postorder:
            return None
        self.postorder = postorder
        root = TreeNode(self.postorder.pop())
        l_inorder, r_inorder = inorder[:inorder.index(root.val)], inorder[inorder.index(root.val)+1:]
        
        # Start construction from right subtree
        self.builder(root, r_inorder, 1)
        self.builder(root, l_inorder, -1)
        return root
