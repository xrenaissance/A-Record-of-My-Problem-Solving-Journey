package DFST;

/**
 * @leetcode https://leetcode.com/problems/diameter-of-binary-tree/
 * @link  https://www.educative.io/collection/page/5668639101419520/5671464854355968/5691878833913856
 * @author Egbert Li
 * @date 11/7/2019
 */
public class TreeDiameter {
    public static int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 0;
    }
    public static int findFromAnyNode(TreeNode currNode) {
        if (currNode == null) {
            return 0;
        }
        int left = findFromAnyNode(currNode.left);
        int right = findFromAnyNode(currNode.right);
        return 1 +  Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
