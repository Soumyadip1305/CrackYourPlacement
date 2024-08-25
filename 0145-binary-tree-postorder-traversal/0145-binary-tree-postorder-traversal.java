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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        solve(root,ans);
        return ans;
    }
    static void solve(TreeNode node,List<Integer>ans){
        if(node==null)return;
        if(node.left!=null){
            solve(node.left,ans);
        }
        if(node.right!=null){
           solve(node.right,ans);
        }
        ans.add(node.val);

    }
}