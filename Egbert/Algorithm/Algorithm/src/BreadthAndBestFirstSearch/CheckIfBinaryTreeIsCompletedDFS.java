package BreadthAndBestFirstSearch;
import Tree.TreeNode;

/**
 * @author Egbert Li
 * @date 4/4/2019
 * if Binary Tree is completed, then the max index must
 * be equal to the total number of nodes
 * start from root, index = 1
 * Time complexity is O(n)
 * Space complexity O(Height)
 */
public class CheckIfBinaryTreeIsCompletedDFS {
    int count = 0;
    int max = 0;
    public boolean isCompleted(TreeNode root) {
        dfs(root, 1);
        return count == max;
    }
    private void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        } else {
            count ++;
            max = Math.max(max, index);
            dfs(root.left, index * 2);
            dfs(root.right, index * 2 + 1);
        }
    }
}
