package Tree;

/**
 * @author Egbert Li
 * @date 2/04/2019
 * Time Complexity O(n)
 * Space Complexity(height) ,worst --> O(n)
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1+ minDepth(root.left);
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
