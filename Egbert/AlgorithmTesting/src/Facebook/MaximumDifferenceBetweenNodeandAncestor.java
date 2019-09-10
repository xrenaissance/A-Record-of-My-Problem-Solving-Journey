package Facebook;

/**
 * @leetcode https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * @Time N
 * @Space height
 */
public class MaximumDifferenceBetweenNodeandAncestor {
    // clean solution top down
    public int maxAncestorDiffDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }

        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }

    // my initial solution: DFS
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int[] max = new int[] {Integer.MIN_VALUE};
        maxDiff(root.val, root.left, max);
        maxDiff(root.val, root.right, max);

        return max[0];
    }

    public void maxDiff(int ancestorValue, TreeNode decendant, int[] max) {
        if (decendant == null) {
            return;
        }

        max[0] = Math.max(Math.abs(ancestorValue - decendant.val), max[0]);
        maxDiff(ancestorValue, decendant.left, max);
        maxDiff(ancestorValue, decendant.right, max);

        maxDiff(decendant.val, decendant.left, max);
        maxDiff(decendant.val, decendant.right, max);
    }
}
