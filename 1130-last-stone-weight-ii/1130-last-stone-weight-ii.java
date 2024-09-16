class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length,sum=Arrays.stream(stones).sum();
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - stones[i - 1]];
                }
            }
        }
        int s1 = 0;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                s1 = j;
                break;
            }
        }
        return Math.abs(sum - s1 - s1);
    }
}