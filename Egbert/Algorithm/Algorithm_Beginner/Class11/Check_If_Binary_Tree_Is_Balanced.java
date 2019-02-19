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
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true; 
    }
    if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
      return true && isBalanced(root.left) && isBalanced(root.right);
    } else {
      return false; 
    }
    
  }
  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = 1 + getHeight(root.left);
    int rightHeight = 1 + getHeight(root.right);
    if (leftHeight > rightHeight) {
      return leftHeight; 
    }
    return rightHeight;
  }
}
