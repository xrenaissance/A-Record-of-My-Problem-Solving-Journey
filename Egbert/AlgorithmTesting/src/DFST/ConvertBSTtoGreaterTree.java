package DFST;

/**
 * @leetcode https://leetcode.com/problems/convert-bst-to-greater-tree/
 * @Time N
 * @Space height
 */
public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        int[] prefixSum = new int[1];
        sumDfs(root, prefixSum);
        return root;
    }
    private void sumDfs(TreeNode root, int[] prefixSum) {
        if (root == null) {
            return;
        }
        sumDfs(root.right, prefixSum);
        prefixSum[0] += root.val;
        root.val = prefixSum[0];
        sumDfs(root.left, prefixSum);
    }
}
