package DFST;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5714315743068160
 * @author Egbert Li
 * @date 10/7/2019
 * @Time O N log N
 * @Space N log N
 */
public class MaxPathSumRootToLeaf {
    public static int maxPathSum(TreeNode root) {
        int[] globalMax = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, 0, globalMax);
        return globalMax[0];
    }
    private static void maxPathSum(TreeNode currNode, int currSum,
                                   int[] globalMax) {
        if (currNode == null) {
            return;
        }
        currSum += currNode.val;
        if (currNode.left == null && currNode.right == null) {
            globalMax[0] = Math.max(currSum, globalMax[0]);
        } else {
            maxPathSum(currNode.left, currSum, globalMax);
            maxPathSum(currNode.right, currSum, globalMax);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Max path sum from root to leaf: " + MaxPathSumRootToLeaf.maxPathSum(root));
    }
}
