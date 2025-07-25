class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums.length,target,nums);
    }
    public static int countPartitions(int n, int d, int[] arr) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        //Checking for edge cases
        if (totSum - d < 0 || (totSum - d) % 2!=0) return 0;

        return findWays(arr, (totSum - d) / 2);
    }

    public static int findWays(int[] num, int tar) {
        //  int[][] dp = new int[num.length + 1][tar + 1];
//        for (int[] row : memo) Arrays.fill(row, -1);
//        return totalSubset(0, num, tar, memo);

//        int[] dp = new int[tar + 1];
//        int n = num.length;
//        dp[0] = 1;
//        for (int i = 0; i < n; i++) {
//            for (int j = tar; j >= num[i]; j--) {
//                dp[j] = (dp[j] + dp[j - num[i]]);
//            }
//        }
//        return dp[tar];
        int n = num.length;
        int[] dp = new int[tar + 1];

        if (num[0] == 0) dp[0] = 2;  // 2 cases - pick and not pick
        else dp[0] = 1;  // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar) dp[num[0]] = 1;  // 1 case - pick

        for (int ind = 1; ind < n; ind++) {
            int[] temp = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int nt = dp[target];
                int take = 0;
                if (num[ind] <= target)
                    take = dp[target - num[ind]];
                temp[target] = (nt + take) ;
            }
            dp = temp;
        }
        return dp[tar];
    }

    static int totalSubset(int ind, int[] arr, int target, int[][] memo) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }
        if (memo[ind][target] != -1) return memo[ind][target];
        // pick
        int notTaken = totalSubset(ind - 1, arr, target, memo);

        int taken = 0;
        if (arr[ind] <= target)
            taken = totalSubset(ind - 1, arr, target - arr[ind], memo);

        return memo[ind][target] = (notTaken + taken);
    }
}
