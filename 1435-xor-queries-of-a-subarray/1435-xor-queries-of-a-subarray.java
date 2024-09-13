class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         int n = arr.length;
         int m=queries.length;
         int[]ans=new int[m];
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                ans[i] = arr[0];
            }
            return ans;
        }
            int ind=0;
            for (int i=0;i<m ;i++ ) {
                int l=queries[i][0];
                int r=queries[i][1];
                int x=arr[l];
                for(int j=l+1;j<=r;j++){
                    x^=arr[j];
                }
                ans[ind++]=x;
                
            }
            return ans;
    }
}