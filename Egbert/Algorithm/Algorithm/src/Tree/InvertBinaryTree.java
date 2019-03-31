package Tree;

/**
 * @author Egbert Li
 * @date 1/04/2019
 * Time Complexity: O(n)
 * Space Complexity: O(height)
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftCopy = root.left;
        root.left = root.right;
        root.right = leftCopy;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
