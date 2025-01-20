class Solution {
    HashMap<String,Double> map;
    long mod = 1000000007;
    long[] fact;
    long[] dp;
    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        map = new HashMap<>();
        long ans = 0;
        int n = nums.length;
        fact(n);
        for(int i:nums){
            ans = (ans +i)%mod;
        }
        ans = (ans *2)%mod;
        if(k==1){
            return (int) ans;
        }
        for(int p = 2; p<=k; p++){
            for(int i=0;i<n;i++){
                long left = (i > 0) ? ncr(i , p - 1) : 0;
                long right =(i < n - 1) ? ncr(n - i - 1, p - 1) : 0;
                ans = (ans + (left + right)*nums[i])%mod;
            }
        }
        return (int) ans;
    }
    long ncr(int n,int r){
        if (r > n || r < 0) return 0;
        return (fact[n] * dp[r] % mod * dp[n - r] % mod) % mod;

    }
    void fact(int n) {
        fact = new long[n + 1];
        dp = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
        dp[n] = pow(fact[n], mod - 2);
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = (dp[i + 1] * (i + 1)) % mod;
        }
    }

    long pow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}