package Tree;

/**
 * @leetcode https://leetcode.com/problems/closest-binary-search-tree-value/
 * @Time height
 * @Space 1
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        int result = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return result;
    }
}
