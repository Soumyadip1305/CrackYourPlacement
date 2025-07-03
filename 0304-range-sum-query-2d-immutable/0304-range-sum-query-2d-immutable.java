class NumMatrix {
static int[][] pref;
    public NumMatrix(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;

     pref = new int[n + 1][m + 1]; 

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            pref[i][j] = arr[i - 1][j - 1]
                       + pref[i - 1][j]
                       + pref[i][j - 1]
                       - pref[i - 1][j - 1];
        }
    }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pref[row2 + 1][col2 + 1]
         - pref[row1][col2 + 1]
         - pref[row2 + 1][col1]
         + pref[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */