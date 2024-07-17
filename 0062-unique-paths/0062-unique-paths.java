class Solution {
    public int uniquePaths(int m, int n) {
      int[]prev=new int[n];
        int[]curr=new int[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                curr[c] = (r == 0 || c == 0) ? 1 : prev[c] + curr[c - 1];
            }
            prev=curr.clone();
        }
        return curr[n - 1];
    }
}