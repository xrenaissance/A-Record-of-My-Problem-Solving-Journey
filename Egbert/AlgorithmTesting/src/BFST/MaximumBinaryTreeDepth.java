package BFST;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @leetcode https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @author Egbert Li
 * @date 7/7/2019
 * @Time O N
 * @Space O Height
 */
public class MaximumBinaryTreeDepth {
   // Solution 1: DFS
   public static int findDepth(TreeNode root) {
       if (root == null) {
           return 0;
       }
       Deque<TreeNode> stack = new ArrayDeque<>();
       Deque<Integer> depth = new ArrayDeque<>();
       stack.offerLast(root);
       depth.offerLast(1);
       int maxDepth = 0;
       while (!stack.isEmpty()) {
           TreeNode currNode = stack.pollLast();
           int currDepth = depth.pollLast();
           maxDepth = Math.max(currDepth, maxDepth);
           if (currNode.right != null) {
              stack.offerLast(currNode.right);
              depth.offerLast(currDepth + 1);
           }
           if (currNode.left != null) {
               stack.offerLast(currNode.left);
               depth.offerLast(currDepth + 1);
           }
       }
       return maxDepth;
   }

    // Solution 2: BFS
    public static int findDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);;
        root.right.right = new TreeNode(5);
        System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth.findDepth(root));
    }
}
