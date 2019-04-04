package Tree;

/**
 * @author Egbert Li
 * @date 3/04/2019
 * Second time 4/4/2019
 * Time Complexity: O (height)
 * Space Complexity: O(height)
 */
public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        // guranteed root != null
        if (root.key > key) {
            root.left = deleteTree(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteTree(root.right, key);
            return root;
        }

        // found the node
        // case1: root.left == null -> return root.right
        // case 2: root.right == null --> return root.left
        // case 3: 1 and 2 solved root.left == null && root.right == null --> return null
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // now we guranteed that root.left != null && root.right != null
        // case 4.1 root.right.left == null
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        // case 4.2
        TreeNode smallest = deleteSmallest(root.right);
        // then connect root.left and root.right
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }
    private TreeNode deleteSmallest(TreeNode rootRight) {
        TreeNode currNode = rootRight.left;
        TreeNode prevNode = rootRight;
        while (currNode.left != null) {
            prevNode = currNode;
            currNode = currNode.left;
        }
        prevNode.left = currNode.right;
        return currNode;
    }
}
