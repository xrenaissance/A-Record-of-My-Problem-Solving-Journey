package Tree;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/count-complete-tree-nodes/
 * @Time N
 * @Space 2 ^ height
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) {
                queue.offer(node.left);
            } else {
                break;
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return count + queue.size();
    }
}
