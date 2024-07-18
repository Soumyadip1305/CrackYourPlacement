/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {

        int total[] = new int[1];

        countPairs(root, distance, total);

       return total[0];
    }

    ArrayList<Integer> countPairs(TreeNode root, int d, int[] total) {

        if (root == null) {
            return new ArrayList<Integer>();
        }

        if (root.left == null && root.right == null) {
            return new ArrayList<Integer>(Arrays.asList(0));
        }

        ArrayList<Integer> left = countPairs(root.left, d, total);

        ArrayList<Integer> right = countPairs(root.right, d, total);
        
        update(left);

        update(right);

        total[0] += count(left, right, d);

        left.addAll(right);

        return left;

    }

    int count(ArrayList<Integer> left, ArrayList<Integer> right, int d) {
        int cnt = 0;

        for (int val1 : left) {
            for (int val2 : right) {
                if (val1 + val2 <= d) {
                    cnt ++;
                }
            }
        }
        return cnt;

    }

    void update(ArrayList<Integer>arr){
        int n = arr.size();

        for(int i = 0; i < n; i++){
            arr.set(i,arr.get(i)+1);
        }
    }

}