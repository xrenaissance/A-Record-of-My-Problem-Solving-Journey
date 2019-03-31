package Tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftCopy = root.left;
        root.left = root.right;
        root.right = leftCopy;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
