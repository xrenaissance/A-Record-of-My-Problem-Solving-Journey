package Facebook;

/**
 * @leetcode https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @Time N
 * @Space height
 */
public class LowestCommonAncestorofaBinarySearchTree {
    // solution 1 same as solution2 but iterative way
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        while ((root.val - (long)p.val) * (root.val - (long)q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }

        return root;
    }
    // Solution 2: if the given tree is bst
    // just walk down from whole tree's root as long as p and q are
    // in the same subtree, meaning their values are both smaller or
    // larger than root's
    public TreeNode lowestCommonAncestorSolRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if ((root.val - (long)p.val) * (root.val - (long)q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
            return lowestCommonAncestor(root, p, q);
        }

        return root;
    }

   // Solution 1
    // if one of the nodes is root, so the lca is root
    // if p and q can be found in different subtree then lca is root
    // if p and q are in the same subtree, then keep searching
    // if one of result from left or right is null, then return to non-null value
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
