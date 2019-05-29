package BinarySearchTree;

/**
 * @author Egbert Li
 * @date 29/05/2019
 * @Time O Height
 * @Space O 1
 */
public class LargestNumberSmallerInBinarySearchTree {
    public int largestSmaller(TreeNode root, int target) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;
            } else {
                // the candidates are all the nodes on the path of
                // searching for target, which is smaller than target
                // and notice that, the later searched node has lager
                // value than the earlier searched ones
                result = root.key;
                root = root.right;
            }
        }
        return result;
    }
}