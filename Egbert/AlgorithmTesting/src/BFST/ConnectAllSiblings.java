package BFST;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5588868243914752
 * @author Egbert Li
 * @Date 9/7/2019
 * @Time O N
 * @Space O N/2
 */
public class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode dummyHead = new TreeNode(-1);
        TreeNode currNode = null;
        TreeNode nextLevelStart = root;
        while (root != null) {
            currNode = dummyHead;
            while (root != null) {
                if (root.left != null) {
                    currNode.next = root.left;
                    currNode = currNode.next;
                    nextLevelStart = currNode;
                }
                if (root.right != null) {
                    currNode.next = root.right;
                    currNode = currNode.next;
                    nextLevelStart = currNode;
                }
                root = root.next;
            }
            System.out.print("Start: " + nextLevelStart.val + "   " + "  End: ");
            root = dummyHead.next;
            //nextLevelStart.next = dummyHead.next;
            System.out.print(nextLevelStart.val);
            System.out.println("----------------");
            dummyHead.next = null;
        }
    }
    // Solution 2: BFS with queue
    public static void connectBFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode prev = null;
        TreeNode currNode = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                currNode = queue.poll();
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
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
