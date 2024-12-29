class Solution {
    public int minimumOperations(int[][] grid) {
        int cnt = 0;

        for (int j = 0; j < grid[0].length; j++) {
            int prev=grid[0][j];
            for (int i = 1; i < grid.length; i++) {
                int curr = grid[i][j];
                if (curr <= prev) {
                    cnt += prev - curr + 1;
                    prev++;
                } else {
                    prev = curr;
                }
              //  System.out.print(prev + " ");
            }
        }

        return cnt;
    }
}