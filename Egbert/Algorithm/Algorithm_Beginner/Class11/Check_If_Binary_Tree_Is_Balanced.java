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
    return getHeight(root) == -1 ? false : true;
  }
  
  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0; 
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if (leftHeight == -1 || rightHeight == -1) {
      return -1; 
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1; 
    }
    return 1 + Math.max(leftHeight, rightHeight);
  }
}
