class Solution {
    public int concatenatedBinary(int n) {
         long mod=(long) 1e9+7;
        long bits = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) bits++;//Increased bits when i is a power of 2.
            ans = ((ans << bits) + i)%mod;

        }
        return (int) ans;
    }
}