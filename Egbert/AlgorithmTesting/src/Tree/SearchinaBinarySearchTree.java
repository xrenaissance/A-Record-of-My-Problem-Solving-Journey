package Tree;

/**
 * @leetcode https://leetcode.com/problems/search-in-a-binary-search-tree/
 * @Time height
 * @Sapce 1
 */
public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
