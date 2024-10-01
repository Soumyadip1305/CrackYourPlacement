/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return inorder(root, null);
    }

    private TreeNode inorder(TreeNode node, TreeNode last) {
        if (node == null) return last;
        TreeNode res = inorder(node.left, node);
        node.left = null;
        node.right = inorder(node.right, last);
        return res;
    }
}