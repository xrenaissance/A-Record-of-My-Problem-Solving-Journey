package DFST;

/**
 * @lintcode https://www.lintcode.com/problem/maximum-subtree/description?_from=ladder&&fromId=14
 * @Time N
 * @Space height
 */
public class MaximumSubtree {
    TreeNode maxNode;
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        getMaxSum(root, max);
        return maxNode;
    }
    private int getMaxSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftSub = getMaxSum(root.left, max);
        int rightSub = getMaxSum(root.right, max);
        if (maxNode == null || leftSub + rightSub + root.val > max[0]) {
            maxNode = root;
            max[0] = leftSub + rightSub + root.val;
        }
        return leftSub + rightSub + root.val;
    }
}
