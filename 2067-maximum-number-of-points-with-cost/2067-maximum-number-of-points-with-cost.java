class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long ans = Integer.MIN_VALUE;

        long[][] dp = new long[n][m];

        for(int i = 0; i < m; i++){
            dp[n - 1][i] = points[n - 1][i];
        }
        for(int r = n - 2; r >= 0; r--){
            long max = Integer.MIN_VALUE;
            for(int j = 0; j < m ; j++ ){
                max = Math.max(max, dp[r +1][j] + j);
                dp[r][j] = max + points[r][j] - j;

            }
            max = Integer.MIN_VALUE;
            for(int c = m - 1; c >= 0; c--){
                max = Math.max(max, dp[r + 1][c] - c);
                dp[r][c] = Math.max(dp[r][c], max + points[r][c] + c);
            }
        }
        for(int i = 0; i < m; i++){
            ans = Math.max(ans, dp[0][i]);
        }
        return ans;
    }
}