class Solution {
        int n ;int[] sufSum;int[][] dp;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        sufSum = new int[n];
        sufSum[n - 1] = piles[n - 1];
        dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = n - 2; i >= 0; i--) {
            sufSum[i] = piles[i] + sufSum[i + 1];
        }
        return allPossibleTake(0, 1);
    }

    private int allPossibleTake( int ind, int m) {
        if (ind >= n) {  // all piles have been taken
            return 0;
        }
        if (dp[ind][m] != -1) return dp[ind][m];
        // If Alice can take all the remaining piles
        if (ind + 2 * m >= n) {
            return dp[ind][m]=sufSum[ind];
        }

        int maxi = 0;

        // Try taking all possible number of piles from 1 to 2*m
        for (int x = 1; x <= 2 * m; x++) {
            int bob = allPossibleTake(ind + x, Math.max(m, x));
            maxi = Math.max(maxi, sufSum[ind] - bob);
        }

        return dp[ind][m] = maxi;
    }
}