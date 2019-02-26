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
    if (root == null) {
      return result; 
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode helper = root;
    while (!stack.isEmpty() || helper != null) {
      if (helper != null) {
        stack.push(helper);
        helper = helper.left;
      } else {
        TreeNode currNode = stack.pop();
        result.add(currNode.key);
        helper = currNode.right;
      }
    }
    return result;
  }
}
