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
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result; 
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode currNode = stack.pop();
      if (currNode.right != null) {
        stack.push(currNode.right); 
      }
      if (currNode.left != null) {
        stack.push(currNode.left); 
      }
      result.add(currNode.key);
    }
    return result;
  }
}
