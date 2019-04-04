package Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * @author Egbert Li
 * @date 4/4/2019
 * Time Comlexity O (h)
 * Space Complexity O (height)
 */
public class PostOrderTraversalOfBinaryTreeIterativeBest {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // initial check
        if (root == null) {
            return result;
        }
        // instaniate stack
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prevNode = null;
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.peekLast();
            // going down
            if (prevNode == null || currNode == prevNode.left || currNode == prevNode.right) {
                if (currNode.left != null) {
                    stack.offerLast(currNode.left);
                } else if (currNode.right != null) {
                    stack.offerLast(currNode.right);
                } else {
                    result.add(currNode.key);
                    stack.pollLast();
                }
            } else if (prevNode == currNode.left) { // prevNode is left child of currNode
                if (currNode.right != null) {
                    stack.offerLast(currNode.right);
                } else {
                    result.add(currNode.key);
                    stack.pollLast();
                }
            } else { // from right subtree
                result.add(currNode.key);
                stack.pollLast();
            }
            prevNode = currNode;
        }
        return result;
    }
}
