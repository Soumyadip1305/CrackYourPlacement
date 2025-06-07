class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n + 1][3][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProf(0, 0, k, prices, dp);
    }

    static int maxProf(int ind, int buy, int cnt, int[] price, int[][][] dp) {
        if (cnt == 0) return 0;
        if (ind == price.length) return 0;
        if (dp[ind][buy][cnt] != -1) return dp[ind][buy][cnt];
        int profit;
        if (buy == 0) {   // buying stock or not
            profit = Math.max(-price[ind] + maxProf(ind + 1, 1, cnt, price, dp), maxProf(ind + 1, 0, cnt, price, dp));
        } else {// selling stock or not
            profit = Math.max(price[ind] + maxProf(ind + 1, 0, cnt - 1, price, dp), maxProf(ind + 1, 1, cnt, price, dp));
        }
        return dp[ind][buy][cnt] = profit;
    }
}
