class Solution {
    public int uniquePaths(int m, int n) {
        // (0,0)--->(m,n)
        int[][]dp=new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=-1;
            }
        }
        return solve(m - 1, n - 1,dp);
    }

    private int solve(int r, int c, int[][] dp) {
        if (r == 0 && c == 0) dp[0][0]= 1;
        if (dp[r][c]!=-1)return dp[r][c];
        int cnt=0;
        if (r>0){
            cnt+=solve(r-1,c, dp);
        }
        if (c>0){
            cnt+=solve(r,c-1, dp);
        }
        return dp[r][c]=cnt;
    }
}