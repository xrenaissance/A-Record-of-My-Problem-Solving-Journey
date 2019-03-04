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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> result = new LinkedList<Integer>();
    helper(root, result, min, max);
    return result;
  }
  
  private void helper(TreeNode root, List<Integer> result, int min, int max) {
    if (root == null) {
      return; 
    }
    if (root.key > min) {
      helper(root.left, result, min, max);   
    }
    if (root.key >= min && root.key <= max) {
      result.add(root.key);
    }
    if (root.key < max) {
      helper(root.right, result, min, max); 
    }
    
  }
}
