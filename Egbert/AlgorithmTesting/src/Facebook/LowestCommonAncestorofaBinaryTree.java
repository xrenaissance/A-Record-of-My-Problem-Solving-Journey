package Facebook;

/**
 * @leetcode https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Time N = number of nodes
 * @Space height
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode ll = lowestCommonAncestor(root.left, p, q);
        TreeNode rl = lowestCommonAncestor(root.right, p, q);

        if (ll != null && rl != null) {
            return root;
        }

        return ll == null ? rl : ll;
    }
}
