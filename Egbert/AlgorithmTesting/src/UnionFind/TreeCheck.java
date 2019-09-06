package UnionFind;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TreeCheck {
    public String treeCheck(int[][] relationships, int n) {
        if (n < 0) {
            return "E5";
        }
        // for no node or one node return true
        if ((relationships == null || relationships.length == 0) && (n == 0 || n == 1)) {
            return "";
        }
        int[] ancestor = new int[n];
        Arrays.fill(ancestor, -1);

        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        for (int[] relation : relationships) {
            if (relation[0] == relation[1]) {
                return "E5";
            }
            TreeNode parent = nodeMap.getOrDefault(relation[0], new TreeNode(relation[0]));
            TreeNode child = nodeMap.getOrDefault(relation[1], new TreeNode(relation[1]));

            // local relationship building



            if (parent.left != null && parent.right != null) {
                if (parent.left.val == child.val || parent.right.val == child.val) {
                    return "E2";
                }
                return "E1";
            }
            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            if (child.parent != null) {
                return "E3";
            }
            child.parent = parent;

            // update ancestor: Union Find like
            if (!updateAncestor(ancestor, relation[0], relation[1])) {
                return "E3";
            }

            nodeMap.put(relation[0], parent);
            nodeMap.put(relation[1], child);
        }
        if (!checkOneAncestor(ancestor)) return "E4";
        int root = findRoot(ancestor);
        StringBuilder resultBuilder = new StringBuilder();
        buildResult(resultBuilder,nodeMap.get(root));
        return resultBuilder.toString();

    }

    /**
     *
     * @param ancestor
     * @param parent
     * @param child
     * @return boolean false -> cycle
     */
    private boolean updateAncestor(int[] ancestor, int parent, int child) {

        // find root; set ancestor to root
        if (ancestor[parent] == -1) {
            ancestor[child] = parent;
        } else {
            // update recursively
            updateAncestor(ancestor, ancestor[parent], parent);
            ancestor[child] = ancestor[parent];
        }
        return ancestor[child] != child;
    }

    private boolean checkOneAncestor(int[] ancestor) {
        int root = -1;
        int negativeOneCount = 0;
        for (int x : ancestor) {
            if (x == -1) {
                negativeOneCount++;
            } else if (root == -1) {
                root = x;
            } else if (root != x) {
                return false;
            }

        }
        return negativeOneCount == 1;
    }

    private int findRoot(int[] ancestor) {
        for (int x : ancestor) {
            if (x != -1) {
                return x;
            }
        }
        return -1;
    }

    private void buildResult(StringBuilder resultBuilder, TreeNode root) {
        if (root == null) {
            return;
        }
        resultBuilder.append('(');
        resultBuilder.append(root.val);
        buildResult(resultBuilder,root.left);
        buildResult(resultBuilder,root.right);

        resultBuilder.append(')');
    }
}

class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}