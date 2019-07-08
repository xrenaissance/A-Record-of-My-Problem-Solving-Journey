package BFST;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5649521866440704
 * @author Egbert Li
 * @date 8/7/2019
 * @Time O N N means total number of nodes
 * @Space O N
 */
public class ConnectLevelOrderSiblings {
    // Solution 1: O N, O 1 Space
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode levelStart = root;
        while (levelStart != null) {
            TreeNode curr = levelStart;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }

    // Solution 2: BFS O N Time, O 1 Space
    public static void connectBFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prev = null;
            // System.out.println("Start size: " + size);
            for (int i = 0; i < size; i++) {
                // System.out.println("---------");
                TreeNode currNode = queue.poll();
                // System.out.println(currNode.val  + "  ---");
                // currNode.next = queue.peek();
                if (prev != null) {
                    prev.next = currNode;
                }
                prev = currNode;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                // prev = currNode;
            }
            // System.out.println("End Size: " + size);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
