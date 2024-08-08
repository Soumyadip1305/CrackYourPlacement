class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        int step = 1, ind = 0;

        int r = rStart, c = cStart;

        ans[ind++] = new int[]{r, c};

        while (ind < rows * cols) {
            // Right
            for (int i = 0; i < step; i++) {
                c++;
                if (check(r, c, rows, cols)) {
                    ans[ind++] = new int[]{r, c};
                }
            }
            // Down
            for (int i = 0; i < step; i++) {
                r++;
                if (check(r, c, rows, cols)) {
                    ans[ind++] = new int[]{r, c};
                }
            }
            step++;
            // Left
            for (int i = 0; i < step; i++) {
                c--;
                if (check(r, c, rows, cols)) {
                    ans[ind++] = new int[]{r, c};
                }
            }
            // Up
            for (int i = 0; i < step; i++) {
                r--;
                if (check(r, c, rows, cols)) {
                    ans[ind++] = new int[]{r, c};
                }
            }
            step++;
        }
        return ans;
    }

    boolean check(int r, int c, int m, int n) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }
}