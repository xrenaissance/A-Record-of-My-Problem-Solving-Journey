package BinarySearchTree;

public class SearchInBinarySearchTreeRecursion {
    public TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.key == key) {
            return root;
        } else if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}
