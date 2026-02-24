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
    public int sumRootToLeaf(TreeNode root) {
         List<String> list = new ArrayList<>();
        helper(root, "", list);
        int ans=0;
        for (String s:list){
            for (int i = 0; i < s.length(); i++) {
                ans+=(s.charAt(i)-'0')*(1<<s.length()-i-1);
            }
        }
//        System.out.println(list);
//        System.out.println(ans);
        return ans;
    }

    static void helper(TreeNode root, String path, List<String> ans){

        if(root == null) return;

        if(path.isEmpty()){
            path = String.valueOf(root.val);
        }else{
            path = path + root.val;
        }

        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        helper(root.left, path, ans);
        helper(root.right, path, ans);
    }
}