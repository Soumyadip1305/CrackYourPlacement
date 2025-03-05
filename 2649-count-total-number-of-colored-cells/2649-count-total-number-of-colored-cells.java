class Solution {
    public long coloredCells(int n) {
        long ans=1;

        for (long i = 2; i <=n ; i++) {
            ans+=(4*(i-1));
        }
        return ans;
    }
}