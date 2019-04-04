package BreadthAndBestFirstSearch;
import java.util.Queue;
import Tree.TreeNode;
import java.util.LinkedList;

/**
 * @author Egbert Li
 * @date 4/4/2019
 * Time Complexity: O(n)
 * Space Complexity: O(2 ^ log(height))
 */
public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null && node.left == null || flag == 1 && (node.left != null || node.right != null)) {
                    return false;
                }
                if (node.left != null && node.right == null || node.left == null && node.right == null) {
                    flag = 1;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}
