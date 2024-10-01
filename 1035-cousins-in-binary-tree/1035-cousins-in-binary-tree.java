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
    public boolean isCousins(TreeNode root, int x, int y) {
         xd = -1;
        yd = -1;
        xp = null;
        yp = null;

        dfs(root, x, y);
        return xd == yd && xp != yp;
    }
    static void dfs(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
    }

    static int xd = -1, yd = -1;
    static TreeNode xp = null, yp = null;

    static void dfs(TreeNode node, int x, int y, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            xd = depth;
            xp = parent;
        } else if (node.val == y) {
            yd = depth;
            yp = parent;
        }

        dfs(node.left, x, y, depth + 1, node);
        dfs(node.right, x, y, depth + 1, node);
    }
}