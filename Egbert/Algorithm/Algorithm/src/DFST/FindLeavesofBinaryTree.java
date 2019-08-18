package DFST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode https://leetcode.com/problems/find-leaves-of-binary-tree/
 * @Time N
 * @Space height
 */
public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> heightBucket = new HashMap<>();
        int maxHeight = getHeight(root, heightBucket);
        for (int i = 1; i <= maxHeight; i++) {
            result.add(heightBucket.get(i));
        }
        return result;
    }
    private int getHeight(TreeNode root, Map<Integer, List<Integer>> heightBucket) {
        if (root == null) {
            return 0;
        }
        int height = Math.max(getHeight(root.left, heightBucket),
                getHeight(root.right, heightBucket)) + 1;
        heightBucket.putIfAbsent(height, new ArrayList<>());
        heightBucket.get(height).add(root.val);
        return height;
    }
}
