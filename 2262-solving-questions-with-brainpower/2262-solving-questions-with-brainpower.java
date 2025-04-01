class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);
    }
    private long solve(int ind, int[][] questions, long[] dp) {
        if (ind >= questions.length) return 0;
        if (dp[ind] != -1) return dp[ind];

        long take = questions[ind][0] + solve(ind + questions[ind][1] + 1, questions, dp);
        long nt = solve(ind + 1, questions, dp);
        return dp[ind] = Math.max(take, nt);
    }
}