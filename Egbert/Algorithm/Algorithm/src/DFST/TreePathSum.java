package DFST;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link https://leetcode.com/problems/path-sum/
 * @author Egbett Li
 * @date 10/7/2019
 * @Time O N
 * @Space O 2 * Height
 */
public class TreePathSum {
    // Solution 1: Iteration
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> sums = new ArrayDeque<>();
        stack.offerLast(root);
        sums.offerLast(sum);
        while (!stack.isEmpty() && root != null) {
            int value = sums.pollLast();
            TreeNode currNode = stack.pollLast();

            if (currNode.left == null && currNode.right == null && currNode.val == value) {
                return true;
            }
            if (currNode.right != null) {
                stack.offerLast(currNode.right);
                sums.offerLast(value - currNode.val);
            }
            if (currNode.left != null) {
                stack.offerLast(currNode.left);
                sums.offerLast(value - currNode.val);
            }
        }
        return false;
    }
    // Solution 2: Recursion
    public static boolean hasPathRecursive(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathRecursive(root.left, sum - root.val) ||
                hasPathRecursive(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
    }
}
