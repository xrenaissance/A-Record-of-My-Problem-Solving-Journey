package DFST;

/**
 * @leetcode https://leetcode.com/problems/binary-tree-upside-down/
 * @Time N
 * @Space height
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        return upsideDownHelper(root);
    }
    public TreeNode upsideDownHelper(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownHelper(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.right = null;
        root.left = null;
        return newRoot;
    }
    public TreeNode upsideDownBinaryTreeIterativ3(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode curr = root, prevRight = null, prev = null;
        while (curr != null) {
            TreeNode next = curr.left;

            // swap
            TreeNode currRight = curr.right;
            curr.left = prevRight;
            curr.right = prev;
            prevRight = currRight;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
