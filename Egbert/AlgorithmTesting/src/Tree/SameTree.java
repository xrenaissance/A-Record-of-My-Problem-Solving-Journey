package Tree;

/**
 * @leetcode https://leetcode.com/problems/same-tree/
 * @date 29/7/2019
 * @Time m + n visit every each node on both p and q
 * @Space O height
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
