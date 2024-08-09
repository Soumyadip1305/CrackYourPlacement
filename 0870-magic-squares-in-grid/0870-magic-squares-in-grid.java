class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int cnt = 0;
        
        for (int i = 0; i <= r - 3; i++) {
            for (int j = 0; j <= c - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    private static boolean isMagicSquare(int[][] grid, int r, int c) {
        int[] cnt = new int[16];
        
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || cnt[val] > 0) {
                    return false;
                }
                cnt[val]++;
            }
        }
        
        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        
        for (int i = 0; i < 3; i++) {
            if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != sum) {
                return false;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (grid[r][c + j] + grid[r + 1][c + j] + grid[r + 2][c + j] != sum) {
                return false;
            }
        }
        
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum) {
            return false;
        }
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != sum) {
            return false;
        }
        
        return true;
    }
}