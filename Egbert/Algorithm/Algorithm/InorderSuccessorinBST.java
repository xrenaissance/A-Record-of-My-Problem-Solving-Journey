package DFST;

/**
 * @leetcdoe https://leetcode.com/problems/inorder-successor-in-bst/
 * @Time height
 * @Space height
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessorIterative(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successor;
        }
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
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
