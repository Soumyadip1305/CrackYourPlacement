class Solution {
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n + 1][n + 1]; // dp[remaining][num]
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, x, 1,dp);
    }
    
    private int solve(int rem, int x, int num,int[][]dp) {
        long pow = (long) Math.pow(num, x);
        if (pow > rem) return 0;
        if (pow == rem) return 1;
        
        if (dp[rem][num] != -1) return dp[rem][num];
        
        int take = solve(rem - (int) pow, x, num + 1,dp);
        int nt = solve(rem, x, num + 1,dp);
        
        return dp[rem][num] = (int) ((take + (long) nt) % 1000000007);
    }
}