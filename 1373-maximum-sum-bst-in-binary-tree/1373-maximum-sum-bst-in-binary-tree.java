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
    class Node {
        int min, max, sum;
        boolean isBST;

        Node(int min, int max, int sum, boolean isBST) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        solve(root);
        return ans;
    }

    private Node solve(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        Node l = solve(root.left);
        Node r = solve(root.right);

        if (l.isBST && r.isBST && l.max < root.val && root.val < r.min) {

            int sum = l.sum + r.sum + root.val;
            ans = Math.max(ans, sum);

            int min = Math.min(root.val, l.min);
            int max = Math.max(root.val, r.max);

            return new Node(min, max, sum, true);
        }

        return new Node(0, 0, 0, false);
    }
}