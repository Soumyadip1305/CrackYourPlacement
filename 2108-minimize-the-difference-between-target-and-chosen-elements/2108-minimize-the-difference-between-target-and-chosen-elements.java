class Solution {
   // private int mini = Integer.MAX_VALUE;

    public int minimizeTheDifference(int[][] mat, int target) {
       int n = mat.length;
        int[][] dp = new int[n + 1][4901];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(mat, 0, 0, target, dp);
    }

    private int solve(int[][] mat, int row, int curr, int target, int[][] dp) {
        if (row == mat.length) {
            return Math.abs(curr - target);
        }

        if (dp[row][curr] != -1) {
            return dp[row][curr];
        }

        int mini = Integer.MAX_VALUE;

        for (int val : mat[row]) {
            int difference = solve(mat, row + 1, curr + val, target, dp);
            mini = Math.min(mini, difference);
        }

       return dp[row][curr] = mini;
    }
}