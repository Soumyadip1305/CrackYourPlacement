class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) == 'b') {
                dp[i] = dp[i - 1];
                cnt++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, cnt);
            }
        }
        return dp[n];
    }
}