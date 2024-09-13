class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         int n = arr.length;
        int m = queries.length;
        int[] prefixXOR = new int[n];
        int[] ans = new int[m];
        prefixXOR[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = prefixXOR[r];
            } else {
                ans[i] = prefixXOR[r] ^ prefixXOR[l - 1];
            }
        }
        
        return ans;
    }
}