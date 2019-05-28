package BinarySearchTree;

/**
 * @author Egbert Li
 * @date 28/05/2019
 * @Time O (Height)
 * @Space O(1)
 */
public class ClosestNumberInBinarySearchTree {
    public int closest(TreeNode root, int target) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int result = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            }
            if (Math.abs(root.key - target) < Math.abs(result - target)) {
                result = root.key;
            } else {
                if (target > root.key) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return result;
    }
}
