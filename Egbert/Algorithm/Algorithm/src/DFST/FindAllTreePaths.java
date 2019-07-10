package DFST;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/path-sum-ii/
 * @author Egbert Li
 * @date 10/7/2019
 * @Time O N
 * @Space
 */
public class FindAllTreePaths {
    public static List<List<Integer>> findPathsDFS(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> sums = new ArrayDeque<>();
        List<Integer> currPath = new ArrayList<>();
        stack.offerLast(root);
        sums.offerLast(sum);
        while (!stack.isEmpty() && root != null) {
            TreeNode currNode = stack.pollLast();
            int currSum = sums.pollLast();
            currPath.add(currNode.val);
            if (currNode.val == currSum && currNode.left == null &&
                    currNode.right == null) {
                allPaths.add(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }
            if (currNode.right != null) {
                stack.offerLast(currNode.right);
                sums.offerLast(currSum - currNode.val);
            }
            if (currNode.left != null) {
                stack.offerLast(currNode.left);
                sums.offerLast(currSum - currNode.val);
            }
        }
        return allPaths;
    }

    // Solution 2: Recursion
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currLayer = new ArrayList<>();
        findPathsHelper(root, sum, currLayer, allPaths);
        return allPaths;
    }
    private static void findPathsHelper(TreeNode root, int sum,
                                        List<Integer> currLayer,
                                        List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }
        currLayer.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currLayer));
        } else {
            findPathsHelper(root.left, sum - root.val, currLayer, allPaths);
            findPathsHelper(root.right, sum - root.val, currLayer, allPaths);
        }
        currLayer.remove(currLayer.size() - 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
