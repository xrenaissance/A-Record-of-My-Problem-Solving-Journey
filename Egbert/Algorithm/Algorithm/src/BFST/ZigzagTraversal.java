package BFST;
import java.util.*;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5706163895140352
 * @leetcode https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author Egbert Li
 * @date 7/2019
 * @Time O N means total number of nodes
 * @Space O N/2 the max number of nodes in a level
 */
public class ZigzagTraversal {
    // Solution 1: using definition of doubly linked list
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int leftToRight = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (leftToRight == 1) {
                    currLevel.add(currNode.val);
                } else {
                    currLevel.add(0, currNode.val);
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(currLevel);
            leftToRight = 1 - leftToRight;
        }
        return result;
    }

    // Solution 2:  Using Deque to traverse
    public static List<List<Integer>> traverseDeque(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        int flag = 1;
        deque.offerLast(root);
        TreeNode currNode = null;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (flag == 1) {
                    currNode = deque.pollFirst();
                    if (currNode.left != null) {
                        deque.offerLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        deque.offerLast(currNode.right);
                    }
                } else {
                    currNode = deque.pollLast();
                    if (currNode.right != null) {
                        deque.offerFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        deque.offerFirst(currNode.left);
                    }
                }

                level.add(currNode.val);
            }
            flag = 1 - flag;
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
