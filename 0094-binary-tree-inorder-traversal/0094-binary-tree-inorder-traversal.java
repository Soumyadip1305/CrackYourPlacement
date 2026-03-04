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
        if(root==null)return new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        solve(root,ans);
        return ans;
    }
    static void solve(TreeNode root,List<Integer>ans){
        if(root==null)return;
        if(root.left!=null)solve(root.left,ans);
        ans.add(root.val);
        if(root.right!=null)solve(root.right,ans);
    }
}