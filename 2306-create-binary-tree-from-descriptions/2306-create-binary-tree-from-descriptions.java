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
    public TreeNode createBinaryTree(int[][] descriptions) {
         Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            nodeMap.putIfAbsent(parent, new TreeNode(parent));
            TreeNode parentNode = nodeMap.get(parent);
            nodeMap.putIfAbsent(child, new TreeNode(child));
            TreeNode childNode = nodeMap.get(child);

            
            if (isLeft) { // Link parent and child
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(child);  // child node
        }

        // Find the root node (a node that is never a child)
        TreeNode root = null;
        for (int key : nodeMap.keySet()) {
            if (!children.contains(key)) {
                root = nodeMap.get(key);
                break;
            }
        }

        return root;
    }
}