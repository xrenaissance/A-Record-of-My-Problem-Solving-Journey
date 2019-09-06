package DFST;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * @author Egbert Li
 * @date 10/7/2019
 * @Time N          O N * log N
 * @Space height     O N log N
 */
public class SumRootToLeafNumbers {
    // Solution 1: on pass
    public int sumNumbers(TreeNode root) {
        int[] total = new int[1];
        getSum(root, 0, total);
        return total[0];
    }
    private void getSum(TreeNode currNode, int sum, int[] total) {
        if (currNode == null) {
            return;
        }
        sum = 10 * sum + currNode.val;
        if (currNode.left == null && currNode.right == null) {
            total[0] += sum;
        } else {
            getSum(currNode.left, sum, total);
            getSum(currNode.right, sum, total);
        }
    }

    // Solution 2: Navie DFS
    public int sumNumbersNavie(TreeNode root) {
        List<String> paths = new ArrayList<>();
        StringBuilder currPath = new StringBuilder();
        allPaths(root, currPath, paths);
        int total = 0;
        for (String s : paths) {
            total += strToInt(s);
        }
        return total;
    }
    private void allPaths(TreeNode currNode, StringBuilder currPath,
                          List<String> paths) {
        if (currNode == null) {
            return;
        }
        currPath.append(currNode.val);
        if (currNode.left == null && currNode.right == null) {
            paths.add(currPath.toString());
        } else {
            allPaths(currNode.left, currPath, paths);
            allPaths(currNode.right, currPath, paths);
        }
        currPath.deleteCharAt(currPath.length() - 1);
    }
    private int strToInt(String path) {
        if (path == null || path.length() == 0) {
            return 0;
        }
        int length = path.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += (path.charAt(i) - '0') * Math.pow(10, length - i - 1);
        }
        return result;
    }
}
