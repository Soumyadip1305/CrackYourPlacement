class Solution {
    public int findMaxForm(String[] arr, int m, int n) {
             /// int[][][] dp=new int[arr.length+1][m+1][n+1];
//        for (int i = 0; i < 601; i++) {
//            for (int j = 0; j < 101; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        return solve(0, m, n, arr, dp);
        /* Tabulation*/
//        for (int ind = arr.length-1; ind >=0; ind--) {
//            for (int m_0 = 0; m_0 <=m ; m_0++) {
//                for (int n_1 = 0; n_1 <=n ; n_1++) {
//                    int zero = (int) arr[ind].chars().filter(ch -> ch == '0').count();// zero cnt
//                    int one = arr[ind].length() - zero; // one cnt
//
//                     dp[ind][m_0][n_1]= (m_0 - zero >= 0 && n_1 - one >= 0)?
//                            Math.max(1 + dp[ind + 1][ m_0 - zero][ n_1 - one],
//                                    dp[ind + 1][m_0] [n_1]):dp[ind + 1] [m_0] [n_1];
//                }
//            }
//        }
//        return dp[0][m][n];
        
        /*  Opt*/
        int [][]prev=new int[m+1][n+1];
        for (int ind = arr.length-1; ind >=0; ind--) {
            int [][]curr=new int[m+1][n+1];
            for (int m_0 = 0; m_0 <=m ; m_0++) {
                for (int n_1 = 0; n_1 <=n ; n_1++) {
                    int zero = (int) arr[ind].chars().filter(ch -> ch == '0').count();// zero cnt
                    int one = arr[ind].length() - zero; // one cnt

                    curr[m_0][n_1]= (m_0 - zero >= 0 && n_1 - one >= 0)?
                            Math.max(1 +prev[ m_0 - zero][ n_1 - one],
                                    prev[m_0] [n_1]):prev [m_0] [n_1];
                }
            }
            prev=curr.clone();
        }
        return prev[m][n];
    }

    private static int solve(int ind, int m, int n, String[] arr, int[][][] dp) {
        if (ind >= arr.length) return 0;

        if (dp[ind][m][n] != -1) return dp[ind][m][n];
        int zero = (int) arr[ind].chars().filter(ch -> ch == '0').count();// zero cnt
        int one = arr[ind].length() - zero; // one cnt

            return dp[ind][m][n]= (m - zero >= 0 && n - one >= 0)?
                    Math.max(1 + solve(ind + 1, m - zero, n - one, arr, dp),
                    solve(ind + 1, m, n, arr, dp)):solve(ind + 1, m, n, arr, dp);
    }
}
