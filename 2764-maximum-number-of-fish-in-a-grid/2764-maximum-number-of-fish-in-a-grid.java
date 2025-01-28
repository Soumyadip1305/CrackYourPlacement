class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxi = 0;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && vis[i][j] == 0) {
                    maxi = Math.max(maxi, solve(i, j, grid, vis));
                }
            }
        }

        return maxi;

    }

    static int solve(int r, int c, int[][] grid, int[][] vis) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return 0;
        if (grid[r][c] == 0 || vis[r][c] == 1) return 0;

        vis[r][c] = 1;
        int sum = grid[r][c];
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            sum += solve(r + rowDir[i], c + colDir[i], grid, vis);
        }

        return sum;
    }
}