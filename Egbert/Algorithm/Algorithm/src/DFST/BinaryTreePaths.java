package DFST;
import java.util.List;
import java.util.ArrayList;

/**
 * @leetcode https://leetcode.com/problems/binary-tree-paths/
 * @author Egbert Li
 * @date 10/7/2019
 * @Time N/2 * log N
 * @Space N/2 * log N
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder currLayer = new StringBuilder();
        findPaths(root, currLayer, result);
        return result;
    }
    private static void findPaths(TreeNode root, StringBuilder currLayer,
                                  List<String> result) {
        if (root == null) {
            return;
        }
        // since one digit will count for 1 letter, 23 -> length is 2
        int startLength = currLayer.length();
        // System.out.print("tempLength: " + tempLength + "   ");
        currLayer.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            result.add(currLayer.substring(0, currLayer.length() - 2));
            System.out.println("----------------------------");
        } else {
            findPaths(root.left, currLayer, result);
            findPaths(root.right, currLayer, result);
        }
        // System.out.print("currLength: " + currLayer.length() + "  ");
        // System.out.println();
        currLayer.delete(startLength, currLayer.length());
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<String> allPath = BinaryTreePaths.binaryTreePaths(root);
        for (String s : allPath) {
            System.out.println(s);
        }
    }
}
