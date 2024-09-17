class Solution {
    public int getMoneyAmount(int n) {
        int[][]dp=new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        return solve(1, n,dp);
    }

    private static int solve(int l, int h, int[][] dp) {
        if (l >= h) return 0;
        int mini = Integer.MAX_VALUE;
        if (dp[l][h]!=Integer.MAX_VALUE)return dp[l][h];

        for (int guess = l; guess <= h; guess++) {
            int take = guess + Math.max(solve(l, guess - 1, dp), solve(guess + 1, h, dp));
            mini = Math.min(mini, take); //skip not take because it always gives small
        }

        return dp[l][h]= mini;
    }
}