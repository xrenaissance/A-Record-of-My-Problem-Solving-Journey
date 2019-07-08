package BFST;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5742636757417984
 * @author Egbert Li
 * @date 8/7/2019
 * @Time O N
 * @Space O N/2
 */
import java.util.Queue;
import java.util.ArrayDeque;
public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
            if (currNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
