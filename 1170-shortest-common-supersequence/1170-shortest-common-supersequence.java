class Solution {
    public String shortestCommonSupersequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = 0;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = 0;
        for (int ind1 = 1; ind1 <= a.length(); ind1++) {
            for (int ind2 = 1; ind2 <= b.length(); ind2++) {
                if (a.charAt(ind1 - 1) == b.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }


        StringBuilder ans = new StringBuilder();
        int i = a.length(), j = b.length();
        while (j > 0 && i > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(a.charAt(i - 1));
                i--;
            } else {
                ans.append(b.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            ans.append(a.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(b.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
}