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
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true; 
    }
    return helper(root.left, root.right);
  }
  
  public boolean helper(TreeNode one, TreeNode two) {
    if (one == null && two == null) {
      return true;
    }
    
    if (one == null || two == null) {
      return false; 
    }
    
    if (one.key != two.key) {
      return false; 
    }
    boolean isLeft = helper(one.left, two.right);
    boolean isRight = helper(one.right, two.left);
    return isLeft && isRight;
  }
}
