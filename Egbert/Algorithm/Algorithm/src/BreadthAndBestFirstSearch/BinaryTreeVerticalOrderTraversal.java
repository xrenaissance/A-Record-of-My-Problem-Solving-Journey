package BreadthAndBestFirstSearch;
import java.util.*;

/**
 * @leetcode https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * @Time n  n = number of nodes
 * @Space worst case 2 ^ height
 */
public class BinaryTreeVerticalOrderTraversal {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> colsMap = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.offer(root);
        colQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            int col = colQueue.poll();
            TreeNode currNode = nodeQueue.poll();
            colsMap.computeIfAbsent(col, k -> new ArrayList<>()).add(currNode.val);
            if (currNode.left != null) {
                colQueue.offer(col - 1);
                nodeQueue.offer(currNode.left);
            }
            if (currNode.right != null) {
                colQueue.offer(col + 1);
                nodeQueue.offer(currNode.right);
            }
        }
        int min = Collections.min(colsMap.keySet());
        int max = Collections.max(colsMap.keySet());
        for (int i = min; i <= max; i++) {
            result.add(colsMap.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal btv = new BinaryTreeVerticalOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(btv.verticalOrder(root).toString());
    }
}
