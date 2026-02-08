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
    public boolean isBalanced(TreeNode root) {
      // left difirance of hight of everey node should <=1 else return false

        return solve(root)!=-1;
    }

    static int solve(TreeNode root) {
        if (root==null)return 0;

        int lh=solve(root.left);
        if(lh==-1)return lh;
        int rh=solve(root.right);
        if(rh==-1)return rh;
        if (Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}