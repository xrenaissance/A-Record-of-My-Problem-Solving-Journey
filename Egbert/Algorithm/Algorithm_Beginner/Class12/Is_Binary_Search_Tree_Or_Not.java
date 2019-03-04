/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public boolean isBST(TreeNode root) {
    return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }
  private boolean isBST(TreeNode root, int min, int max) {
    if (root == null) {
      return true; 
    }
    if (root.key >= min || root.key <= max) {
      return false; 
    }
    return isBST(root.left, root.key, max) && isBST(root.right, min, root.key);
  }
}
