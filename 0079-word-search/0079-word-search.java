class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, r, c, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, int ind, String word) {
        if (ind == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(ind)) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '*';
        boolean poss = dfs(board, r, c + 1, ind + 1, word) || dfs(board, r, c - 1, ind + 1, word) || dfs(board, r - 1, c, ind + 1, word) || dfs(board, r + 1, c, ind + 1, word);
        board[r][c] = temp;
        return poss;
    }
}