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
    List<Integer> result = new ArrayList<Integer>();
    helper(root, result, min, max);
    Collections.sort(result);
    return result;
  }
  
  private void helper(TreeNode root, List<Integer> result, int min, int max) {
    if (root == null) {
      return; 
    }
    if (root.key > max) {
      helper(root.left, result, min, max); 
    } else if (root.key < min) {
      helper(root.right, result, min, max);
    } else {
      result.add(root.key); 
      helper(root.left, result, min, max);
      helper(root.right, result, min, max);
    }
  }
}
