package LinkedList;

public class ReverseBinaryTreeUpsideDown {
    public TreeNode reverseRecursion(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public TreeNode reverseIteration(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode curr = root, prev = null, prevRight = null;
        while (curr != null) {
            TreeNode next = curr.left;

            // swap nodes
            TreeNode currRight = curr.right;
            curr.left = prev;
            curr.right = prevRight;
            prevRight = currRight;

            // get prev then go to next
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
