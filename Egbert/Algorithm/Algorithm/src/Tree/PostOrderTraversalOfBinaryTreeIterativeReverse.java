package Tree;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Collections;

/**
 * @author Egbert Li
 * @date 4/4/2019
 * Reversed pre-order traversal, then reverse the result
 * Time complexity: O (n)
 * Space complexity O (n)
 */
public class PostOrderTraversalOfBinaryTreeIterativeReverse {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> reversed = new ArrayDeque<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pollLast();
            if (currNode.left != null) {
                stack.offerLast(currNode.left);
            }
            if (currNode.right != null) {
                stack.offerLast(currNode.right);
            }
            reversed.offerLast(currNode);
        }
        while (!reversed.isEmpty()) {
            result.add(reversed.pollLast().key);
        }
        return result;
    }
}
