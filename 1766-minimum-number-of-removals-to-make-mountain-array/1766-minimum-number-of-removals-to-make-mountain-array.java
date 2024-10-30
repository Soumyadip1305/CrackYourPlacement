class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], dp2 = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j > i; --j) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int maxi = 0;

        for (int i = 1; i < n - 1; ++i) {
            if (dp[i] > 1 && dp2[i] > 1) {
                maxi = Math.max(maxi, dp[i] + dp2[i] - 1);
            }
        }

        return n - maxi;
    }
}