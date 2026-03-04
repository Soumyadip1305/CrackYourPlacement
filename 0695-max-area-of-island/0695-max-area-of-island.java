class Solution {
    class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int maxi = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area = bfs(i, j, grid, vis); // get area
                    maxi = Math.max(maxi, area); // update max
                }
            }
        }
        return maxi;
    }

    int bfs(int r, int c, int[][] grid, boolean[][] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        vis[r][c] = true;
        int area = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            area++; // count cell

            // go in 4 dir
            // down
            if (row + 1 < grid.length && !vis[row + 1][col] && grid[row + 1][col] == 1) {
                q.add(new Pair(row + 1, col));
                vis[row + 1][col] = true;

            }
            // up
            if (row - 1 >= 0 && !vis[row - 1][col] && grid[row - 1][col] == 1) {
                q.add(new Pair(row - 1, col));
                vis[row - 1][col] = true;
            }
            // right
            if (col + 1 < grid[0].length && !vis[row][col + 1] && grid[row][col + 1] == 1) {
                q.add(new Pair(row, col + 1));
                vis[row][col + 1] = true;
            }
            // left
            if (col - 1 >= 0 && !vis[row][col - 1] && grid[row][col - 1] == 1) {
                q.add(new Pair(row, col - 1));
                vis[row][col - 1] = true;
            }
        }
        return area;
    }
}