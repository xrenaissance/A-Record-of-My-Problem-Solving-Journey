package DFST;

/**
 * @leetcdoe https://leetcode.com/problems/inorder-successor-in-bst/
 * @Time height
 * @Space height
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return root;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode successor = inorderSuccessor(root.left, p);
            return successor == null ? root : successor;
        }
    }
}
