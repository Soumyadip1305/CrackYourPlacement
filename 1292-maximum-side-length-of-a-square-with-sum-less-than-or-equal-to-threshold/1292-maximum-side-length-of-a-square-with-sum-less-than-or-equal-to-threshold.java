class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] pref = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                        + pref[i - 1][j]
                        + pref[i][j - 1]
                        - pref[i - 1][j - 1];
            }
        }
        int low = 0, high = Math.min(n, m);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isSquare(pref, mid, threshold)) {
                ans = mid;
                low = mid + 1;   // I always find big square ok
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isSquare(int[][] pref, int k, int target) {
        for (int i = k; i < pref.length; i++) {
            for (int j = k; j < pref[0].length; j++) {

                int sum = pref[i][j]
                        - pref[i - k][j]
                        - pref[i][j - k]
                        + pref[i - k][j - k];

                if (sum <= target)
                    return true;
            }
        }
        return false;
    }
}