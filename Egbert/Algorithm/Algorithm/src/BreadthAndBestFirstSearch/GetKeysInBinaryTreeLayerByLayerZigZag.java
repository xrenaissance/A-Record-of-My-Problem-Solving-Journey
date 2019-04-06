package BreadthAndBestFirstSearch;
import java.util.List;
import java.util.Deque;
import java.util.ArrayList;
import java.util.ArrayDeque;
import Tree.TreeNode;

/**
 * @author Egbert Li
 * @date 7/4/2019
 * Time complexity: O(n)
 * Space Complexity: O(2 ^ height)
 */
public class GetKeysInBinaryTreeLayerByLayerZigZag {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        int flag = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            Deque<TreeNode> layer = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = stack.pollLast();
                if (flag == 0) {
                    if (curr.right != null) {
                        layer.offerLast(curr.right);
                    }
                    if (curr.left != null) {
                        layer.offerLast(curr.left);
                    }
                } else {
                    if (curr.left != null) {
                        layer.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        layer.offerLast(curr.right);
                    }
                }
                result.add(curr.key);
            }
            stack = layer;
            flag = 1 - flag;
        }
        return result;
    }
}
