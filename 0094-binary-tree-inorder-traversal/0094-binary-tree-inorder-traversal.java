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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return new ArrayList<>();

        inorder(root,list);
        return list;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root.left!=null)inorder(root.left,list);
        list.add(root.val);
        if (root.right!=null)inorder(root.right, list);
    }
}