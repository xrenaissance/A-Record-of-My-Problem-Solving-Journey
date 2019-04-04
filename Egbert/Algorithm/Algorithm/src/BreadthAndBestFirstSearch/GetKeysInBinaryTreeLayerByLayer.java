package BreadthAndBestFirstSearch;
import Tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author Egbert Li
 * @date 4/4/2019
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class GetKeysInBinaryTreeLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                layer.add(currNode.key);
            }
            result.add(layer);
        }
        return result;
    }
}
