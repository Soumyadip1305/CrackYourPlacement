class Solution {
    public int climbStairs(int n) {
        int[]dp=new int[n+2];
        dp[0]=1;
        dp[1]=1;
        for(int ind=2;ind<=n;ind++){
            dp[ind]=dp[ind-1]+dp[ind-2];
        }
        return dp[n];
    }
    static int solve(int ind,int n,int[]dp){
        if(ind>n){
            return 0;
        }
        if(dp[ind]!=-1)return dp[ind];
        if(ind==n){
            return dp[ind]=1;
        }
        return dp[ind]=solve(ind+1,n,dp)+solve(ind+2,n,dp);
    }
}