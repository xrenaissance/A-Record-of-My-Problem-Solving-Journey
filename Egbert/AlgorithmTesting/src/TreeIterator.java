import java.util.Deque;
import java.util.ArrayDeque;

/**
 * In-order Iterator
 * @author Egbert Li
 * @date 2/04/2019
 * Time Complexity: hasNext() --> O(1), next() worst: --> O(height) Average --> O(1)
 */
public class TreeIterator {
   public Deque<TreeNode> stack;
   public TreeIterator(TreeNode root) {
       stack = new ArrayDeque<>();
      fillStack(root);
   }

    // get next node value
   public int next() {
       TreeNode currNode = stack.pollLast();
       fillStack(currNode.right);
       return currNode.key;
   }

    // check stack
   public boolean hasNext() {
      return stack.isEmpty();
   }

   // push all the left to stack
   public void fillStack (TreeNode root) {
      while (root != null) {
        stack.offerLast(root);
        root = root.left;
      }
   }
}
