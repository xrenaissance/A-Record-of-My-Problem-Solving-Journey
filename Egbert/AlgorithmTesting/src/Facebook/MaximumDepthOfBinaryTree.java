package Facebook;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int maxHeight = Math.max(left, right) + 1;

        return maxHeight;
    }
}
