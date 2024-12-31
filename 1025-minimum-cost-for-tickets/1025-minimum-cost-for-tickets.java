class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
//        Arrays.fill(dp,-1);
//        return solve(0, days, costs, dp);
        for (int i = days.length - 1; i >= 0; i--) {
            int oneDayCost = costs[0] + dp[findInd(i, 1, days)];
            int sevenDayCost = costs[1] + dp[findInd(i, 7, days)];
            int thirtyDayCost = costs[2] + dp[findInd(i, 30, days)];

            dp[i] = Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));
        }

        return dp[0];
    }

    private static int solve(int ind, int[] days, int[] costs,int[]dp) {
        if (ind >= days.length) {
            return 0;
        }
        if (dp[ind]!=-1)return dp[ind];
        int oneDayCost = costs[0] + solve(findInd(ind, 1, days), days, costs, dp);
        int sevenDayCost = costs[1] + solve(findInd(ind, 7, days), days, costs, dp);
        int thirtyDayCost = costs[2] + solve(findInd(ind, 30, days), days, costs, dp);

        return dp[ind]=Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));
    }

    private static int findInd(int ind, int diff, int[] days) {
        int nexD = days[ind] + diff;
        int nexI = ind;

        while (nexI < days.length && days[nexI] < nexD) nexI++;
        return nexI;
    }
}