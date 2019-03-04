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
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    if (one == null && two == null) {
      return true; 
    }
    
    if (one == null || two == null) {
      return false; 
    }
    
    if (one.key != two.key) {
      return false; 
    }
    return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right) ||
           isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
  }
}
