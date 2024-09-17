class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] visit = new boolean[n][m];

        int[] delR = {-1, 1, 0, 0}; // Up, Down, Left, Right
        int[] delC = {0, 0, -1, 1}; // Up, Down, Left, Right

        for (int j = 0; j < m; j++) {
            if (!visit[0][j] && board[0][j] == 'O') {
                dfs(0, j, board, visit, delR, delC);
            }
            if (!visit[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(n - 1, j, board, visit, delR, delC);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i][0] && board[i][0] == 'O') {
                dfs(i, 0, board, visit, delR, delC);
            }
            if (!visit[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, visit, delR, delC);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visit[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, boolean[][] visit, int[] delR, int[] delC) {
        visit[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int newR = r + delR[i];
            int newC = c + delC[i];

            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length
                    && board[newR][newC] == 'O' && !visit[newR][newC]) {
                dfs(newR, newC, board, visit, delR, delC);
            }
        }
    }
}