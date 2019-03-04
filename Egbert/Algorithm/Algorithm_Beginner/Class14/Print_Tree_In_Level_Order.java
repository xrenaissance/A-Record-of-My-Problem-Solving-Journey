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
  public List<Integer> bfs(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result; 
    }
    Deque<TreeNode> queue = new LinkedList<TreeNode>();        
    queue.offerLast(root);
    while (queue.size() > 0) {
      TreeNode currNode = queue.pollFirst();
      result.add(currNode.key);
      if (currNode.left != null) {
        queue.offerLast(currNode.left); 
      }
      if (currNode.right != null) {
        queue.offerLast(currNode.right);
      }
    }
    return result;
  }
}
