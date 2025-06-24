class Solution {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (dp[i] == numWays[i - 1]) continue;
            if ( numWays[i-1]-dp[i]==1) {
                list.add(i);
                for (int j = i; j <= n; j++) {
                    dp[j] += dp[j - i];
                }
            } else  {
                return new ArrayList<>();
            }
        }

        return list;
    }
}