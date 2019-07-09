package BFST;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5639313842765824
 * @author Egbert Li
 * @date 9/7/2019
 * @Time O 2 N
 * @Space O N
 */
public class TreeBoundary {
    public static List<TreeNode> findBoundary(TreeNode root) {
        List<TreeNode>result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> leftView = new ArrayList<>();
        List<TreeNode> rightView = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                if (currNode.left == null && currNode.right == null) {
                    continue;
                } else if (i == 0) {
                    leftView.add(currNode);
                } else if (i == size - 1) {
                    rightView.add(0, currNode);
                }
            }
        }
        List<TreeNode> leaves = findLeavesDFS(root);
        leftView.addAll(leaves);
        leftView.addAll(rightView);
        return leftView;
    }
    private static List<TreeNode> findLeavesDFS(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<TreeNode> leaves = new ArrayList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pollLast();
            if (currNode.left == null && currNode.right == null) {
                leaves.add(currNode);
            }
            if (currNode.right != null) {
                stack.offerLast(currNode.right);
            }
            if (currNode.left != null) {
                stack.offerLast(currNode.left);
            }
        }
        return leaves;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = TreeBoundary.findBoundary(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
};
