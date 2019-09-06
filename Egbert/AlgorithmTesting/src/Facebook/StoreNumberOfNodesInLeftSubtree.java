package Facebook;

/**
 * @licode https://app.laicode.io/app/problem/646
 * @Time N = num of nodes
 * @Space Height
 */
public class StoreNumberOfNodesInLeftSubtree {
    public void numNodesLeft(TreeNodeLeft root) {
        getNumOfLeft(root);
    }
    private int getNumOfLeft(TreeNodeLeft root) {
        if (root == null) {
            return 0;
        }

        int leftNum = getNumOfLeft(root.left);
        int rightNum = getNumOfLeft(root.right);

        root.numNodesLeft = leftNum;
        return leftNum + rightNum + 1;
    }
}
