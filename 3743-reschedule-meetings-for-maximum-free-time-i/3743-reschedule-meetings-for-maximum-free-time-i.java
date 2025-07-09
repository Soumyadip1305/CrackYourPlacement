class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] dp = new int[n + 1];

        dp[0] = startTime[0];
        dp[n] = eventTime - endTime[n - 1];

        for (int i = 1; i < n; i++) {
            dp[i] = startTime[i] - endTime[i - 1];
        }

        int[] pref = new int[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            pref[i] = pref[i - 1] + dp[i - 1];
        }

        int ans = 0;
        for (int i = k + 1; i <= n + 1; i++) {
            ans = Math.max(ans, pref[i] - pref[i - (k + 1)]);
        }

        return ans;
    }
}