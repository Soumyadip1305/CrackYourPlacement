class Solution {
    static int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int r = nums.length - 1, l = 0;
        long ans = 0;

        while (l <=r) {
            if (nums[l] + nums[r] <= target) {
                ans += pow(r - l);
                ans %= mod;
                l++;
            } else {
                r--;
            }
        }
        return (int) ans;
    }

    static int pow(int a) {
    long res = 1, base = 2;
    while (a > 0) {
        if ((a & 1) == 1) res = (res * base) % mod;
        base = (base * base) % mod;
        a >>= 1;
    }
    return (int) res;
}
}