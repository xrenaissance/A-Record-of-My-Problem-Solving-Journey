package Tree;

public class BinaryTreeDiameter {
    public int diameter(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        if (root.left == null) {
            return diameter(root.right);
        } else if (root.right == null) {
            return diameter(root.left);
        }
        int diameter = height(root.left) + height(root.right) + 1;
        int left = diameter(root.left);
        int right = diameter(root.right);
        return Math.max(diameter, Math.max(left, right));
    }
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
