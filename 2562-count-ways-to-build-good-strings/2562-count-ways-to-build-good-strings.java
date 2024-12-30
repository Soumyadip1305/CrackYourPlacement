class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[]dp=new int[high+1];
        Arrays.fill(dp,-1);
        return allPossibleWay(low,high,zero,one,0,dp);
    }
    static int mod = 1000000007;
    static int allPossibleWay(int low, int high, int zero, int one, int size, int[] dp) {
        if (size > high) {
            return 0;
        }
        int cnt = 0;
        if (size >= low) {
            cnt++;
        }
        if (dp[size]!=-1)return dp[size];
        cnt += allPossibleWay(low, high, zero, one, size + zero, dp);
        cnt %= mod;
        cnt += allPossibleWay(low, high, zero, one, size + one, dp);
        cnt %= mod;
        return dp[size]= cnt;
    }
}