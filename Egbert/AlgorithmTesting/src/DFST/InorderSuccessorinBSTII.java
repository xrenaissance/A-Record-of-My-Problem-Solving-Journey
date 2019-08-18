package DFST;

/**
 * @leetcode https://leetcode.com/problems/inorder-successor-in-bst-ii/
 * @Time N
 * @Space 1
 */
public class InorderSuccessorinBSTII {
    public Node inorderSuccessor(Node x) {
        if (x == null) {
            return x;
        }
        if (x.right == null) {
            Node successor = x.parent;
            while (successor != null && successor.val < x.val) {
                successor = successor.parent;
            }
            return successor;
        } else {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }
    }
}
