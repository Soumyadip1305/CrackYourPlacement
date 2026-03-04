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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return sum;
    }

     void solve(TreeNode root,int curr){
        if(root==null)return;
        curr*=10;
        curr+=root.val;
        
        if (root.left == null && root.right == null) {
            sum += curr;
        } else{
        if (root.left != null) solve(root.left, curr);
        if (root.right != null) solve(root.right, curr);
        }
    }
    /* int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        dfs(0,root);
        return sum;
    }
     void dfs(int leafNum,TreeNode root){
        leafNum=leafNum*10+root.val;
        if (root.left == null && root.right == null) {
            sum += leafNum;
        }
         else {
            if (root.left != null) dfs(leafNum, root.left);
            if (root.right != null) dfs(leafNum, root.right);
        }
        */
    }