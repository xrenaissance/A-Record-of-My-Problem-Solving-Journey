package DFST;

/**
 * @link https://www.educative.io/collection/page/5668639101419520/5671464854355968/5750943224168448
 * @author Egbert Li
 * @date 10/7/2019
 * @Time O N
 * @Space Best log N, worst N
 */
public class PathWithGivenSequence {
    // Solution 1: DFS clean code
    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null) {
            return sequence.length == 0;
        }
        return findPathRecursive(root, sequence, 0);
    }
    private static boolean findPathRecursive(TreeNode currNode, int[] sequence,
                                             int currLevel) {
        if (currNode == null) {
            return false;
        }
        if (currLevel >= sequence.length || currNode.val != sequence[currLevel]) {
            return false;
        }
        if (currNode.left == null && currNode.right == null &&
            currLevel == sequence.length - 1) {
            return true;
        }
        return findPathRecursive(currNode.left, sequence, currLevel + 1) ||
                findPathRecursive(currNode.right, sequence, currLevel + 1);
    }

    // Solution 2: not clean solution
    public static boolean findPathNavia(TreeNode root, int[] sequence) {
        boolean[] found = new boolean[1];
        findPath(root, sequence, 0, true, found);
        return found[0];
    }
    public static void findPath(TreeNode currNode, int[] sequence,
                                int currLevel, boolean isRight,boolean[] found) {
        if (currNode == null) {
            return;
        }
        if (currLevel < sequence.length) {
            isRight = (sequence[currLevel] == currNode.val) && isRight;
        } else {
            return;
        }
        if (!isRight) {
            return;
        }
        currLevel++;
        if (currNode.left == null && currNode.right == null && isRight) {
            found[0] = true;
            return;
        } else {
            findPath(currNode.left, sequence, currLevel, isRight, found);
            findPath(currNode.right, sequence, currLevel, isRight, found);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
