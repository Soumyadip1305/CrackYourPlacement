class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dp = new long[26][26];
        long mini = Long.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], mini);
            dp[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            dp[original[i] - 'a'][changed[i] - 'a'] = Math.min(dp[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

       return solve(dp, mini,source,target);
    }
    static long solve(long[][] dp, long inf,String source, String target ){
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dp[i][k] != inf && dp[k][j] != inf) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        long cnt = 0;

        for (int i = 0; i < source.length(); i++) {
            int x = source.charAt(i) - 'a';
            int y = target.charAt(i) - 'a';

            if (source.charAt(i) - 'a' == y) {
                continue;
            }

            if (dp[x][y] == inf) {
                return -1;
            }

            cnt += dp[x][y];
        }
        return cnt;
    }
}