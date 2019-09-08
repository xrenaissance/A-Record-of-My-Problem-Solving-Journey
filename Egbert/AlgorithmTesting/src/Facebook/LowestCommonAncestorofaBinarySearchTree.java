package Facebook;

/**
 * @leetcode https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @Time N
 * @Space height
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // if root is one or two , we can ignore the later recursion
        if (root == p || root == q) {
            return root;
        }

        TreeNode ll = lowestCommonAncestor(root.left, p, q);
        TreeNode lr = lowestCommonAncestor(root.right, p, q);

        if (ll != null && lr != null) {
            return root;
        }

        return ll == null ? lr : ll;
    }
}
