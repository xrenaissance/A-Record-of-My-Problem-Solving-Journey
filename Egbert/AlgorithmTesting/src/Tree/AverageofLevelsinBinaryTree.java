package Tree;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @leetcode https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * @Time N
 * @Space 2 ^ height
 */
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            double avg = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                avg += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(avg / size);
        }
        return result;
    }
}
