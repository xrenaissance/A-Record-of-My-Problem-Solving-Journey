package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @leetcode https://leetcode.com/problems/invert-binary-tree/
 * @date 30/7/2019
 * @Time number of nodes
 * @Space 2 ^ height  or height
 */
public class InvertBinaryTree {
    // Iteration
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            TreeNode left = currNode.left;
            currNode.left = currNode.right;
            currNode.right = left;
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
        return root;
    }

    // Recursion
    public TreeNode invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tempLeft = root.left;
        root.left = invertTreeRecursion(root.right);
        root.right = invertTreeRecursion(tempLeft);
        return root;
    }
}
