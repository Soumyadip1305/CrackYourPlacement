class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sufSum = new int[n];
        sufSum[n - 1] = piles[n - 1];
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            sufSum[i] = piles[i] + sufSum[i + 1];
        }
        return allPossibleTake(piles, sufSum, 0, 1, dp);
    }

    private int allPossibleTake(int[] piles, int[] suffixSum, int ind, int m, int[][] dp) {
        int n = piles.length;
        if (ind >= n) {  // all piles have been taken
            return 0;
        }
        if (dp[ind][m] != -1) return dp[ind][m];
        // If Alice can take all the remaining piles
        if (ind + 2 * m >= n) {
            return dp[ind][m]=suffixSum[ind];
        }

        int maxi = 0;

        // Try taking all possible number of piles from 1 to 2*m
        for (int x = 1; x <= 2 * m; x++) {
            int bob = allPossibleTake(piles, suffixSum, ind + x, Math.max(m, x), dp);
            maxi = Math.max(maxi, suffixSum[ind] - bob);
        }

        return dp[ind][m] = maxi;
    }
}