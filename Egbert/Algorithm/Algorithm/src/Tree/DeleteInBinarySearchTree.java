package Tree;

/**
 * @author Egbert Li
 * @date 3/04/2019
 * Time Complexity: O (height)
 * Space Complexity: O(height)
 */
public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // find target node
        if (root.key > key) {
            root.left = deleteTree(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteTree(root.right, key);
            return root;
        }
        // guarantee root != null && roo.val == target
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // guarantee root.left != null && guarantee root.right != null
        // 4.1
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }

        // 4.2
        // 1. find and delete smallest node in root.right
        TreeNode smallest = deleteSmallest(root.right);
        // 2. connect the smallest node with root.left and root.right
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode deleteSmallest(TreeNode currNode) {
        TreeNode prev = currNode;
        currNode = currNode.left;
        while (currNode.left != null) {
            prev = currNode;
            currNode = currNode.left;
        }
        prev.left = currNode.right;
        return currNode;
    }
}
