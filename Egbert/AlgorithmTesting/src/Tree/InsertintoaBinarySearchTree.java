package Tree;

/**
 * @leetcode https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * @Time height
 * @Space height
 */
public class InsertintoaBinarySearchTree {
    // Iterative
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode currNode = root;
        TreeNode prev = root;
        while (currNode != null) {
            prev = currNode;
            if (currNode.val == val) {
                return root;
            } else if (currNode.val > val) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        if (val < prev.val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
        return root;
    }
    // Solution: Recursion
    public TreeNode insertIntoBSTRecursion(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBSTRecursion(root.right, val);
        } else {
            root.left = insertIntoBSTRecursion(root.left, val);
        }
        return root;
    }
}
