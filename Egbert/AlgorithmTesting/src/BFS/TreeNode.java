package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
    }
    void levelPrint() {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size;i ++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    System.out.print(" " + curr.val + " ");
                } else {
                    System.out.print(" #" + " ");
                }
                if (curr != null) {
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
            System.out.println();
        }
    }
    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null) {
                        nextLevelRoot = current.left;
                    } else if (current.right != null) {
                        nextLevelRoot = current.right;
                    }
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
