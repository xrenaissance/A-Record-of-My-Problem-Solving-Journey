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
  public int findHeight(TreeNode root) {
    if (root == null) {
      return 0; 
    }
    
    int leftHeight = 1 + findHeight(root.left);
    int rightHeight = 1 + findHeight(root.right);
    if (leftHeight > rightHeight) {
      return leftHeight; 
    }
    return rightHeight;
  }
}
