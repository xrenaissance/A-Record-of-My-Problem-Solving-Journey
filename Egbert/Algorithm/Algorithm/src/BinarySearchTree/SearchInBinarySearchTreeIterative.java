package BinarySearchTree;

public class SearchInBinarySearchTreeIterative {
    public TreeNode searchIterative (TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        TreeNode currNode = root;
        while (currNode != null) {
            if (currNode.key == key) {
                return currNode;
            } else if (key < currNode.key) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        return currNode;
    }
}
