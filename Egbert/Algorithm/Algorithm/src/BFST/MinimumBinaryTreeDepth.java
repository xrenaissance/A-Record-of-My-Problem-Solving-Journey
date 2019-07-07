package BFST;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author Egbert Li
 * @date 7/7/2019
 * @Time BFS -> O N  | DFS -> O N
 * @Space BFS -> O N/2 | DFS -> O height
 */
public class MinimumBinaryTreeDepth {
    // Solution 1: DFS
    public static int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    // Solution 2: BFS
    public static int findDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right == null) {
                    return minDepth + 1;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
