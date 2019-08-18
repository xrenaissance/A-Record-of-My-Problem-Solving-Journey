package GoogleTaged;

/**
 * @leetcode https://leetcode.com/problems/range-sum-of-bst/
 * @Time N worst
 * @Space height
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[1];
        dfs(root, l, r, sum);
        return sum[0];
    }
    private void dfs(TreeNode root, int l, int r, int[] sum) {
        if (root == null) {
            return;
        }
        // l <= root.val < r
        if (root.val > l) {
            dfs(root.left, l, r, sum);
        }
        if (root.val >= l && root.val <= r) {
            sum[0] += root.val;
        }
        if (root.val < r) {
            dfs(root.right, l, r, sum);
        }
    }  public int rangeSumBST(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[1];
        dfs(root, l, r, sum);
        return sum[0];
    }
    private void dfs(TreeNode root, int l, int r, int[] sum) {
        if (root == null) {
            return;
        }
        // l <= root.val < r
        if (root.val > l) {
            dfs(root.left, l, r, sum);
        }
        if (root.val >= l && root.val <= r) {
            sum[0] += root.val;
        }
        if (root.val < r) {
            dfs(root.right, l, r, sum);
        }
    }
}
