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
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    traverse(root, result);
    return result;
  }
  
  public void traverse(TreeNode root, List<Integer> result) {
    if (root == null) {
      return; 
    }
    traverse(root.left, result);
    result.add(root.key);
    traverse(root.right, result);
  }
}
