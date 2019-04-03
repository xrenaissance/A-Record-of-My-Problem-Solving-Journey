package Tree;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Egbert Li
 * @date 3/04/2019
 * Time complexity: O(n)
 * Space complexity O(height)
 */
public class InOrderTraversalIterative {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode currNode = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || currNode != null) {
            if (currNode != null) {
                stack.offerLast(currNode);
                currNode = currNode.left;
            } else {
                TreeNode node = stack.pollLast();
                result.add(node.key);
                currNode = node.right;
            }
        }
        return result;
    }
}
