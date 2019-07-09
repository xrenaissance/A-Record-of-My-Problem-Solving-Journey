package BFST;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5838045066559488
 * @author Egbert Li
 * @date 9/7/2019
 * @Time O N
 * @Space O N/2
 */
public class RightViewTree {
    // Solution 1: DFS
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        traverseDFS(root, result, 0);
        return result;
    }
    private static void traverseDFS(TreeNode root,
                                    List<TreeNode> result,
                                    int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root);
        }
        traverseDFS(root.right, result, depth + 1);
        traverseDFS(root.left, result, depth + 1);
    }

    // Solution 2: BFS
    public static List<TreeNode> traverseBFS(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
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
                if (i == size - 1) {
                    result.add(currNode);
                }
            }
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
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
