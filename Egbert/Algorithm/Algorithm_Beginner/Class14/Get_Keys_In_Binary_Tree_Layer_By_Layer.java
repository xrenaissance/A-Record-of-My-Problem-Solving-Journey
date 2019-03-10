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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result; 
    }
    Deque<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);
    while (!q.isEmpty()) {
      List<Integer> currLayer = new ArrayList<Integer>();
      Deque<TreeNode> currQueue = new LinkedList<TreeNode>();
      while (!q.isEmpty()) {
        TreeNode currNode = q.poll();
        currLayer.add(currNode.key);
        if (currNode.left != null) {
          currQueue.offer(currNode.left);
        }
        if (currNode.right != null) {
          currQueue.offer(currNode.right); 
        }
      }
      result.add(currLayer);
      q = currQueue;
    }
    return result;
  }
}
