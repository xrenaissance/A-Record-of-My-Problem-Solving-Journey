package DFST;

/**
 * @leetcode https://leetcode.com/problems/path-sum-iii/
 * @author Egbert Li
 * @date 10/7/2019
 * @Time O N ^ 2
 * @Space O N worst, n log n best case
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int pathFromRoot = count(root, sum); // number of paths from root
        int numOfLeft = pathSum(root.left, sum); // number of paths from left subtree
        int numOfRight = pathSum(root.right, sum); // number of paths from right subtree
        return pathFromRoot + numOfLeft + numOfRight;
    }
    private int count(TreeNode anyNode, int sum) {
        if (anyNode == null) {
            return 0;
        }
        int numOfCurrNode = anyNode.val == sum ? 1 : 0; // if itself could be a path
        int numOfLeft = count(anyNode.left, sum - anyNode.val); // get how many remaining we can get from left subtree
        int numOfRight = count(anyNode.right, sum - anyNode.val); // get how many remaining we can get from right subtree
        return numOfCurrNode + numOfLeft + numOfRight;
    }
}
