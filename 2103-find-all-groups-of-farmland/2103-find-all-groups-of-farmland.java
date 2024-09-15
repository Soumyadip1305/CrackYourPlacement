class Solution {
    public int[][] findFarmland(int[][] land) {
        int n = land.length, m = land[0].length;
        boolean[][] visit = new boolean[n][m];
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visit[i][j]) {
                    int[] bottomRight = dfs(land, visit, i, j);
                    ans.add(new int[]{i, j, bottomRight[0], bottomRight[1]});
                }
            }
        }
        return ans.toArray(new int[0][]);    }

    static int[] dfs(int[][] land, boolean[][] visit, int r, int c) {
        int n = land.length, m = land[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m || land[r][c] == 0 || visit[r][c]) {
            return new int[]{r - 1, c - 1};
        }

        visit[r][c] = true;
        int[] down = dfs(land, visit, r + 1, c);
        int[] right = dfs(land, visit, r, c + 1);

        return new int[]{Math.max(r, down[0]), Math.max(c, right[1])};
    }
}