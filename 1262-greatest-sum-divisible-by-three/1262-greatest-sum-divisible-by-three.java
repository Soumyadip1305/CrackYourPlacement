class Solution {
        public int maxSumDivThree(int[] nums) {
                 int n = nums.length;
//        int[][] dp = new int[n+1][3];
//        for (int[] row : dp) Arrays.fill(row, -1);
//        return getMax(n - 1, 0, nums, dp);
//        dp[0][1] = Integer.MIN_VALUE;  // 0
//        dp[0][2] =  Integer.MIN_VALUE;  // 0
//
//        for(int i = 1 ; i <= n ; i++){
//            for(int sum = 2; sum >= 0 ; sum--){
//                dp[i][sum] = Math.max(nums[i-1] + dp[i-1][(sum +nums[i-1])%3], dp[i-1][sum]);
//            }
//        }
//        return dp[n][0];

        /* Space Opt */
        int[] prev = new int[3];

        prev[1] = Integer.MIN_VALUE;
        prev[2] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] curr = new int[3];
            for (int j = 0; j < 3; j++) {
                curr[j] = Math.max(prev[j], prev[(j - nums[i] % 3 + 3) % 3] + nums[i]);
            }
            prev = curr;
        }

        return prev[0];
    }

    static int getMax(int n, int sum, int[] nums, int[][] dp) {
        if (n < 0) {
            return (sum % 3) == 0 ? sum : 0;
        }
        if (dp[n][sum % 3] != -1) return dp[n][sum % 3];
        return dp[n][sum % 3] = Math.max(getMax(n - 1, sum + nums[n], nums, dp), getMax(n - 1, sum, nums, dp));
    }
}