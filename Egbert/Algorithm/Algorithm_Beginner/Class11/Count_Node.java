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
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0; 
    }
    int leftTotal = countNodes(root.left);
    int rightTotal = countNodes(root.right);
    return 1 + leftTotal + rightTotal;
  }
}
